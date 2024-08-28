package com.nttdata.steps;

import com.nttdata.screens.VistaProductoScreen;
import net.thucydides.core.annotations.Step;

public class VistaProductoSteps {

   VistaProductoScreen vistaProductoScreen;

    @Step("Agrego unidades del producto {int}")
    public void agregoUnidades(int cant) {

        vistaProductoScreen.AgregoUnidades(cant);
    }

    @Step("Selecciono el boton Agregar al Carro")
    public void AddCart() {

        vistaProductoScreen.AddCart();
    }

    @Step("Valido el Item Cart coincida con la Cant de productos")
    public void validoProductoAgregado() {
        vistaProductoScreen.ValidoItemCart();
    }
}
