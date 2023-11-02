package webapp.stepdefintions;


import webapp.pageobjects.CommonPage;
import webapp.utils.DriverManager;

import io.cucumber.java.en.*;


public class CommonSteps extends DriverManager {
    private CommonPage commonPage;

    public CommonSteps(){
        commonPage = new CommonPage(getDriver());
    }
    @Then("Validate that URL contains {string} text")
    public void validateURL(String url) {
        commonPage.validateURL(url);
    }
}