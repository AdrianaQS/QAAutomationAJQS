package com.nttdata.screens;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VistaProductoScreen extends PageObject {



    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement CantInput;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement AddButton;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement AddCartButton;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartTV")
    private WebElement CantItemsCart;


    public void AgregoUnidades(int cant) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(CantInput));
        int CantInputInt = Integer.parseInt(CantInput.getText());

        while (CantInputInt < cant) {
            AddButton.click();
            CantInputInt = Integer.parseInt(CantInput.getText());
        }
    }

    public void AddCart() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(AddCartButton));
        AddCartButton.click();
    }

    public void ValidoItemCart() {
        int CantInputInt = Integer.parseInt(CantInput.getText());
        int CantItemsCartInt = Integer.parseInt(CantItemsCart.getText());
        Assert.assertEquals(CantInputInt,CantItemsCartInt);
    }
}
