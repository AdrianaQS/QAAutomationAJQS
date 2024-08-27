package com.nttdata.steps;
import com.nttdata.page.CarritoPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CarritoSteps {

    private WebDriver driver;

    //constructor
    public CarritoSteps(WebDriver driver){

        this.driver = driver;
    }

    public String getTitle() {

        return this.driver.findElement(CarritoPage.CarritoTitle).getText();
    }

    public void ValidarMonto() {
        String subtotal = this.driver.findElement(CarritoPage.subtotal).getText();
        String total = this.driver.findElement(CarritoPage.subtotal).getText();
        Assertions.assertEquals(subtotal, total);



    }
}
