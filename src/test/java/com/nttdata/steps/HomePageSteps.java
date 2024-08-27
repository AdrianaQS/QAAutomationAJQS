package com.nttdata.steps;

import com.nttdata.page.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePageSteps {

    private WebDriver driver;

    //constructor
    public HomePageSteps(WebDriver driver){

        this.driver = driver;
    }

    public void IrLogin(){
        this.driver.findElement(HomePage.SignInButton).click();
    }

}
