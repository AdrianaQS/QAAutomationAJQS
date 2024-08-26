package com.nttdata.glue;
import com.nttdata.steps.GestionOrders;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class GestionOrdersStepDef {

    @Steps
    GestionOrders gestionorders;

    @When("se realiza la creación del pedido con los datos {int}, {int}, {int}, {string}, {string}")
    public void seRealizaLaCreaciónDelPedidoConLosDatos(int id, int petId, int quantity, String shipDate, String status) {
        gestionorders.crearpedido(id,petId,quantity,shipDate,status);
    }

    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
        gestionorders.validarCodigoRespuesta(statusCode);
    }

    @And("los datos del response deben ser iguales a id {int}, petId {int}, quantity {int}, shipDate {string}, status {string}")
    public void losDatosDebenSerIgualesAIdPetIdQuantityShipDateStatusComplete(int id, int petId, int quantify, String shipDate, String status) {
        gestionorders.validardatosOrden(id,petId,quantify,shipDate,status);
    }

    @Given("valido  que el usuario tiene un id {int} de un pedido que existe")
    public void validoQueElUsuarioTieneUnIdDeUnPedioQueExiste(int id) {
        Assert.assertTrue("No existe usuario",gestionorders.Consultoid(id));
    }

    @When("consulto el id {int} del pedido")
    public void consultoElIdIdDelPedido(int id) {
        gestionorders.ConsultoPedido(id);
    }

    @And("valido que el id {int} consultado sea igual al del response")
    public void validoQueElIdConsultadoSeaIgualAlDelResponse(int id) {
        gestionorders.validorespuesta(id);
    }
}
