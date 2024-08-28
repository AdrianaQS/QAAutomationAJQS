package com.nttdata.stepsdefinitions;

import com.nttdata.steps.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;


public class MyDemoAppStepsDef {

    @Steps
    CatalogoProductosSteps catalogoProductosSteps;
    @Steps
    VistaProductoSteps vistaProductoSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoy_En_La_Aplicación_De_SauceLabs() {
        catalogoProductosSteps.validarTitulo();
        catalogoProductosSteps.LogoisVisible();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void valido_Que_Carguen_Correctamente_Los_Productos_En_La_Galeria() {
        catalogoProductosSteps.ProductosCargados();
    }

    @When("selecciono el siguiente producto {string}")
    public void seleccionoElSiguienteProducto(String nameProduct) {
        catalogoProductosSteps.SeleccionoProducto(nameProduct);
    }

    @And("agrego {int} del producto")
    public void agregoUNIDADESDelProducto(int cant) {
        vistaProductoSteps.agregoUnidades(cant);
        vistaProductoSteps.AddCart();
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        vistaProductoSteps.validoProductoAgregado();
    }
}
