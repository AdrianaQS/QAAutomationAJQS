package com.nttdata.steps;

import com.nttdata.page.CatalogoProductosPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CatalogoProductosSteps {
    private WebDriver driver;

    public CatalogoProductosSteps(WebDriver driver){

        this.driver = driver;
    }

    public void NavegarCategoria(String categoria) {
        List<WebElement> categorias = this.driver.findElements(CatalogoProductosPage.categoria);
        boolean categoriaEncontrada = false;

        for (WebElement cat : categorias) {
            String categoriaTexto = cat.getText();

            if (categoriaTexto.equalsIgnoreCase(categoria)) {
                cat.click();
                categoriaEncontrada = true;
                break;
            }
        }

        Assert.assertTrue("Categoría '" + categoria + "' no encontrada.", categoriaEncontrada);
    }

    public void Navegarsubcategoria(String subcategoria) {
        List<WebElement> subcategorias = this.driver.findElements(CatalogoProductosPage.subCategoria);


        for (WebElement subCat : subcategorias) {
            String subcategoriaTexto = subCat.getText();


            if (subcategoriaTexto.equalsIgnoreCase(subcategoria)) {
                subCat.click();
                break;
            }
        }
    }

    public void escogerProducto() {
        this.driver.findElement(CatalogoProductosPage.producto).click();
    }

}
