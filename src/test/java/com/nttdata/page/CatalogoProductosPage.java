package com.nttdata.page;

import org.openqa.selenium.By;

public class CatalogoProductosPage {
    public static By producto = By.xpath("//*[@id='js-product-list']/div[1]/div/article");
    public static By categoria = By.className("category");
    public static By subCategoria = By.className("category-sub-menu");
}
