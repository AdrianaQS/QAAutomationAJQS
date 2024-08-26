package glue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import steps.GestionOrdersPetStoreStep;

public class GestionOrdersPetStoreStepDef {
    @Steps
    GestionOrdersPetStoreStep gestionOrder;

    @When("envio la solicitud para crear el pedido con id {int}, petId {int}, quantity {int}, shipDate {string}, status {string}, complete {string}")
    public void envioLaSolicitudParaCrearElPedidoConIdPetIdQuantityShipDateStatusComplete(int id, int petId, int quantity, String shipDate, String status, String complete) {
        boolean completes = Boolean.parseBoolean(complete);
        gestionOrder.crearPedido(id,petId,quantity,shipDate,status,completes);
    }

    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
        gestionOrder.validarCodigoRespuesta(statusCode);
    }

    @And("los datos del response deben ser iguales a id {int}, petId {int}, quantity {int}, shipDate {string}, status {string}, complete {string}")
    public void losDatosDebenSerIgualesAIdPetIdQuantityShipDateStatusComplete(int id, int petId, int quantify, String shipDate, String status, String complete) {
        boolean completes = Boolean.parseBoolean(complete);
        gestionOrder.validardatosOrden(id,petId,quantify,shipDate,status,completes);
    }

    @Given("valido  que el usuario tiene un id {int} de un pedido que existe")
    public void validoQueElUsuarioTieneUnIdDeUnPedioQueExiste(String id) {
        Assert.assertTrue("No existe usuario",gestionOrder.Consultoid(id));
    }

    @When("consulto el id {int} del pedido")
    public void consultoElIdIdDelPedido(int id) {
        gestionOrder.ConsultoPedido(id);
    }

    @And("valido que el id {int} consultado sea igual al del response")
    public void validoQueElIdConsultadoSeaIgualAlDelResponse(int id) {
        gestionOrder.validorespuesta(id);
    }
}
