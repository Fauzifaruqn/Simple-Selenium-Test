package webapp.stepdefintions;

import io.cucumber.java.Scenario;
import webapp.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class _Hooks {

    public _Hooks() {}
    @After
    public void quitDriver(Scenario scenario) {
        DriverManager.closeBrowser(scenario);
    }

    @Before
    public void setup() throws IOException {
        DriverManager.driverSetup();
    }
}