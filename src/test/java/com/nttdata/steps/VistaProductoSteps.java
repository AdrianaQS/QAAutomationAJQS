package com.nttdata.steps;

import com.nttdata.page.VistaProducto;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VistaProductoSteps {
    private WebDriver driver;

    public VistaProductoSteps(WebDriver driver){

        this.driver = driver;
    }

    public void AgregarCarrito(int cant) {
        WebElement CantInput = this.driver.findElement(VistaProducto.CantInput);

        CantInput.clear();
        CantInput.sendKeys(Keys.DELETE);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CantInput.sendKeys(String.valueOf(cant));

        this.driver.findElement(VistaProducto.CarritoButton).click();
    }
}
