package steps;
import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
public class GestionOrdersPetStoreStep {

    private String baseUrl = "https://petstore.swagger.io/v2/store/order";


    public void crearPedido(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": 20,\n" +
                        "  \"petId\": 15,\n" +
                        "  \"quantity\": 20,\n" +
                        "  \"shipDate\": \"2024-08-25T01:12:25.780Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log().all()
                .post(baseUrl)
                .then()
                .log().all()
        ;
    }

    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }


    public void validardatosOrden(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        restAssuredThat(response -> response.body("'id'", equalTo(id)));
        restAssuredThat(response -> response.body("'petId'", equalTo(petId)));
        restAssuredThat(response -> response.body("'quantity'", equalTo(quantity)));
        restAssuredThat(response -> response.body("'shipDate'", equalTo(shipDate)));
        restAssuredThat(response -> response.body("'status'", equalTo(status)));
        restAssuredThat(response -> response.body("'complete'", equalTo(complete)));
        System.out.println(SerenityRest.lastResponse().print());

    }


    public boolean Consultoid(String id) {
        boolean existeid = false;
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .log().all()
                .get(baseUrl + "/" +id)
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
                .get(baseUrl + "/" +id)
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

