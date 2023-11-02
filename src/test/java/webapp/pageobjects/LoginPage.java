package webapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {

    By userNameField = By.cssSelector("[data-test=\"username\"]");
    By passwordField = By.cssSelector("[data-test=\"password\"]");
    By loginBtn = By.cssSelector("[data-test=\"login-button\"]");
    By errorMsg = By.className("error-message-container");

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String name) {
        driver.findElement(userNameField).sendKeys(name);
    }
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    public void validateLoginErrorMsg(String expectedErrorText){
        String ActualErrorText = driver.findElement(errorMsg).getText();
        Assert.assertEquals(ActualErrorText, expectedErrorText);
    }

}