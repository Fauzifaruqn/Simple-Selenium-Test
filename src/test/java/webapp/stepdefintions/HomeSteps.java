package webapp.stepdefintions;

import io.cucumber.java.en.And;
import webapp.pageobjects.HomePage;
import webapp.utils.DriverManager;

public class HomeSteps extends DriverManager {

    private HomePage homePage;

    public HomeSteps(){homePage = new HomePage(getDriver());}

    @And("user should be able direct to the home page")
    public void navigateToHomePage(){
        homePage.titleOnPage();
    }

    @And("user choose product with name {string}")
    public void chooseProduct(String nameProduct){
        homePage.productSelected(nameProduct);
    }
}
