package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static listeners.AllureListener.CustomAllureListener.withCustomTemplates;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;

public class Specs {
    public static RequestSpecification requestSpecification = with()
            .filter(withCustomTemplates())
            .baseUri("https://petstore.swagger.io/v2/")
            .log().uri()
            .log().body()
            .log().method()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responsePositive = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.ALL)
            .expectBody(matchesJsonSchemaInClasspath("positiveSchema.json"))
            .build();

    public static ResponseSpecification responseNull = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.ALL)
            .expectBody((matchesJsonSchemaInClasspath("schema.json")))
            .expectBody("id", notNullValue())
            .expectBody("photoUrls", hasSize(0))
            .expectBody("tags", hasSize(0))
            .build();


}
