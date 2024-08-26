package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GestionOrders  {


    public void crearpedido(int id, int petId, int quantity, String shipDate, String status) {
        SerenityRest.given()
                .contentType("application/json")
                .accept("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"petId\": " + petId + ",\n" +
                        "  \"quantity\": " + quantity + ",\n" +
                        "  \"shipDate\": \"" + shipDate + "\",\n" +
                        "  \"status\": \"" + status + "\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log().all()
                .post("https://petstore.swagger.io/v2/store/order")
                .then()
                .log().all()
        ;
    }


    public void validarCodigoRespuesta(int statusCode) {

        restAssuredThat(response -> response.statusCode(statusCode));
    }

    public void validardatosOrden(int id, int petId, int quantity, String shipDate, String status) {
        restAssuredThat(response -> response.body("'id'", equalTo(id)));
        restAssuredThat(response -> response.body("'petId'", equalTo(petId)));
        restAssuredThat(response -> response.body("'quantity'", equalTo(quantity)));
        restAssuredThat(response -> response.body("'shipDate'", equalTo(shipDate)));
        restAssuredThat(response -> response.body("'status'", equalTo(status)));
        System.out.println(SerenityRest.lastResponse().print());

    }

    public boolean Consultoid(int id) {
        boolean existeid = false;
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .get("https://petstore.swagger.io/v2/store/order/"+id)
                .then()
                .log().all()
        ;
        if (lastResponse().statusCode()==200){ existeid=true; }
        return existeid;
    }

    public void ConsultoPedido(int id) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .get("https://petstore.swagger.io/v2/store/order" + "/" +id)
                .then()
                .log().all()
        ;
    }

    public void validorespuesta(int id) {
        SerenityRest.then()
                .statusCode(200)
                .body("id", equalTo(id))
        ;
    }
}

