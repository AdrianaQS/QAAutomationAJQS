package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginSteps {

    private WebDriver driver;
    private WebElement userInputElement;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    public void typeUser(String user){

        userInputElement = driver.findElement(LoginPage.userInput);
        userInputElement.sendKeys(user);
        //Espera implicita
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        //espera explicita
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));


    }

    public void typePassword(String password){

        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    public void login(){

        this.driver.findElement(LoginPage.loginButton).click();
        /*if (this.driver.findElements(LoginPage.Alerterror).size() > 0) {
            throw new RuntimeException("Error: Credenciales inválidas.");
        }*/
    }

}
