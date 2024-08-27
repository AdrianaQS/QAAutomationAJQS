package com.nttdata.page;

import org.openqa.selenium.By;

public class CarritoPage {
    public static By CarritoTitle = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1");
    public static By subtotal = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[2]/span/strong");
    public static By total = By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[1]/div[2]/div[2]/span[2]");
}
