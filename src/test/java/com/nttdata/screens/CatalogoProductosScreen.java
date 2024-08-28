package com.nttdata.screens;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CatalogoProductosScreen extends PageObject {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement titleProduct;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/mTvTitle")
    private WebElement logo;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']/android.view.ViewGroup")
    private List<WebElement> ProductCards;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/titleTV']")
    private List<WebElement> ProductNames;





    public void validarTitulo() {
        System.out.println(titleProduct.getText());
        Assert.assertTrue(titleProduct.isDisplayed());
    }

    public void LogoisVisible() {
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOf(logo));
            Assert.assertTrue("El logo es visible", logo.isDisplayed());
    }

    public void ProductosCargados() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(ProductCards));

        // Verifica que la lista de productos no esté vacía
        Assert.assertFalse("No se encontraron productos en la galería", ProductCards.isEmpty());

    }

    public void SeleccionoProducto(String nameProduct) {
        boolean productoEncontrado = false;

        for (int i = 0; i < ProductNames.size(); i++) {
            if (ProductNames.get(i).getText().equals(nameProduct)) {
                ProductCards.get(i).click();
                productoEncontrado = true;
                break;
            }
        }

        Assert.assertTrue("El producto con el nombre '" + nameProduct + "' no fue encontrado.", productoEncontrado);
    }

}
