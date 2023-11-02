package webapp.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CommonPage {

    private WebDriver driver;

    public CommonPage(WebDriver driver){
        this.driver = driver;
    }
    public void validateURL(String expectedUrl){
        String currentUrl = driver.getCurrentUrl();
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.urlContains(expectedUrl));
    }

}