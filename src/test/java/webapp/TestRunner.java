package webapp;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = {"src/test/java/features"},
        glue = {"webapp.stepdefintions"},
        monochrome = true,
        tags = "@web"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}