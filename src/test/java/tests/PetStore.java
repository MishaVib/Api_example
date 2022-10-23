package tests;

import helpers.Endpoints;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import models.request.Category;
import models.request.RequestModel;
import models.request.TagsItem;
import models.response.ResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specs.requestSpecification;
import static specs.Specs.responsePositive;

public class PetStore {
    @Test
    @Owner("Misha")
    @DisplayName("add new entity")
    @Description("Создание новой сущности через POST запрос")
    void addNewPet() {

        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://kids.britannica.com/kids/article/bulldog/471529");
        List<TagsItem> tags = new ArrayList<>();
        TagsItem tagsItem = new TagsItem();
        tagsItem.setName("#dog");
        tagsItem.setId(1);
        tags.add(tagsItem);
        Category category = new Category();
        category.setId(1);
        category.setName("animal");

        RequestModel requestModel =
                RequestModel.builder()
                        .id(10)
                        .name("Bulldog")
                        .status("available")
                        .tags(tags)
                        .photoUrls(photoUrls)
                        .category(category)
                        .build();

        ResponseModel responseModel = given()
                .spec(requestSpecification)
                .body(requestModel)
                .when()
                .post(Endpoints.PET.title)
                .then()
                .spec(responsePositive)
                .extract().as(ResponseModel.class);
        assertThat(responseModel.getId()).isEqualTo(10);
        assertThat(responseModel.getName()).isEqualTo("Bulldog");
    }
}
