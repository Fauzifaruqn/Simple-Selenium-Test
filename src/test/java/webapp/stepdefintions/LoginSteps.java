package webapp.stepdefintions;
import io.cucumber.java.en.*;
import webapp.pageobjects.LoginPage;
import webapp.utils.DriverManager;

public class LoginSteps extends DriverManager {
    private LoginPage loginPage;

    public LoginSteps(){
        loginPage = new LoginPage(getDriver());
    }

    @When("I enter user name {string} in logIn Screen")
    public void iEnterUserNameOnLogInPage(String userName) {
        loginPage.setUserName(userName);
    }

    @And("I enter password {string} in logIn Screen")
    public void iEnterPasswordOnLogInPage(String password) {
        loginPage.setPassword(password);
    }

    @And("I click on the login button")
    public void iClickLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("Validate the login error {string} message")
    public void validateErrorMsgOnLoginPage(String errorMsg) {
        loginPage.validateLoginErrorMsg(errorMsg);
    }
}