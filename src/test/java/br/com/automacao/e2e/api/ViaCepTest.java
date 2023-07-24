package br.com.automacao.e2e.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ViaCepTest {

    private String URL_VIACEP = "https://viacep.com.br/ws/";

    @BeforeEach
    void init(){
        RestAssured.baseURI = URL_VIACEP;
    }

    @Test
    @DisplayName("Deve validar o CEP passado na URL")
    void deveValidarCep() {
        given()
            .accept(ContentType.JSON)
            .pathParam("CEP", "95095321")
        .when()
            .get("/{CEP}/json")
        .then()
            .assertThat()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("schemas/CepSchema.json"));
    }

    @Test
    @DisplayName("Deve invalidar o CEP passado na URL")
    void deveInvalidarCep() {
        given()
                .accept(ContentType.JSON)
                .pathParam("CEP", "151515")
                .when()
                .get("/{CEP}/json")
                .then()
                .assertThat()
                .statusCode(400)
                .body("html.body.h1", is("Http 400"));
    }
}
