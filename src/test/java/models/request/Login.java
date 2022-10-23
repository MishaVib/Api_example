package models.request;


import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Login {
    @NotNull
    @JsonProperty("first_name")
    private String firstName;
    @NotNull
    @JsonProperty("last_name")
    private String lastName;
    private String email;
    private String phone;
}
