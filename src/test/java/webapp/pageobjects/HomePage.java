package webapp.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    By titleInventory = By.xpath("//div[text()='Swag Labs']");

    By titleProduct = By.xpath("//span[text()='Products']");
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void titleOnPage(){
        driver.findElement(titleInventory).isDisplayed();
        driver.findElement(titleProduct).isDisplayed();
    }

    public void productSelected(String name){

       String productText = driver.findElement(By.xpath("//div[contains(@class,'inventory_item_name') and contains(text(),'"+ name +"')]")).getText();
        Assert.assertTrue(productText.contains(name));

    }
}
