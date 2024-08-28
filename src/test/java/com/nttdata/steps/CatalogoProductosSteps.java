package com.nttdata.steps;

import com.nttdata.screens.CatalogoProductosScreen;
import net.thucydides.core.annotations.Step;

public class CatalogoProductosSteps {

    CatalogoProductosScreen catalogoProductosScreen;

    @Step("Valida titulo")
    public void validarTitulo() {
        catalogoProductosScreen.validarTitulo();
    }

    @Step("Valida que el logo es visible")
    public void LogoisVisible() {
        catalogoProductosScreen.LogoisVisible();
    }

    @Step("Valida que la lista de productos")
    public void ProductosCargados() {
        catalogoProductosScreen.ProductosCargados();
    }

    @Step("Selecciono el producto {string}")
    public void SeleccionoProducto(String nameProduct) {
        catalogoProductosScreen.SeleccionoProducto(nameProduct);
    }
}
