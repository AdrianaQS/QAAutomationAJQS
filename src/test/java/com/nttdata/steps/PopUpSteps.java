package com.nttdata.steps;
import com.nttdata.page.CarritoPage;
import com.nttdata.page.PopUpPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpSteps {
    private WebDriver driver;

    public PopUpSteps(WebDriver driver){

        this.driver = driver;
    }

    public String getMensaje() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PopUpPage.Mensaje));
        return this.driver.findElement(PopUpPage.Mensaje).getText();
    }

    public void CalculoMonto() {
        String subtotal = this.driver.findElement(CarritoPage.subtotal).getText();
        String total = this.driver.findElement(PopUpPage.Total).getText();
        Assertions.assertEquals(subtotal, total);
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PopUpPage.CantProduct));

        WebElement PrecioProduct = driver.findElement(PopUpPage.PrecioProduct);
        WebElement CantProduct = driver.findElement(PopUpPage.CantProduct);
        WebElement Total = driver.findElement(PopUpPage.Total);


        String PrecioProductStr = PrecioProduct.getText();
        String CantProductStr = CantProduct.getText();
        String TotalStr = Total.getText();

        System.out.println(PrecioProductStr);
        System.out.println(CantProductStr);
        System.out.println(TotalStr);


        double PrecioProductDouble = Double.parseDouble(PrecioProductStr.replace("PEN", "").trim());
        int CantProductInt = Integer.parseInt(CantProductStr.trim());
        double TotalDouble = Double.parseDouble(TotalStr.replace("PEN", "").trim());


        double precioTotalEsperado = PrecioProductDouble * CantProductInt;
        Assertions.assertEquals(precioTotalEsperado, TotalDouble);*/

    }

    public void FinalizarCompra() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PopUpPage.ComprarButton));
        this.driver.findElement(PopUpPage.ComprarButton).click();
    }

}
