package com.nttdata.stepsdefinitions;

import com.nttdata.steps.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class MyStoreStepsDef {

    private WebDriver driver;
    private LoginSteps loginSteps;
    private HomePageSteps homePageSteps(WebDriver driver){
        return new HomePageSteps(driver);
    }
    private CatalogoProductosSteps catalogoProductosSteps(WebDriver driver){return new CatalogoProductosSteps(driver);}
    private VistaProductoSteps vistaProductoSteps(WebDriver driver){return new VistaProductoSteps(driver);}
    private PopUpSteps popUpSteps(WebDriver driver){return new PopUpSteps(driver);}
    private CarritoSteps carritoSteps(WebDriver driver){return  new CarritoSteps(driver);}
    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        homePageSteps(driver).IrLogin();
        loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        catalogoProductosSteps(driver).NavegarCategoria(categoria);
        screenShot();
        catalogoProductosSteps(driver).Navegarsubcategoria(subcategoria);
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cant) {
        catalogoProductosSteps(driver).escogerProducto();
        screenShot();
        vistaProductoSteps(driver).AgregarCarrito(cant);
        screenShot();

    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {

        String mensajeEsperado = "\uE876Producto añadido correctamente a su carrito de compra";
        String mensaje = popUpSteps(driver).getMensaje();
        Assertions.assertEquals(mensajeEsperado, mensaje);
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {

        popUpSteps(driver).CalculoMonto();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        popUpSteps(driver).FinalizarCompra();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        String TituloEsperado = "CARRITO";
        String Titulo = carritoSteps(driver).getTitle();
        Assertions.assertEquals(TituloEsperado, Titulo);
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        carritoSteps(driver).ValidarMonto();
        screenShot();
    }
}
