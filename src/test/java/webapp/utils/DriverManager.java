package webapp.utils;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;

import static org.bouncycastle.util.Properties.getPropertyValue;


public class DriverManager {
    public static WebDriver driver;
    private static final boolean runOnBrowserStack = false;

    public static void driverSetup() throws FileNotFoundException, MalformedURLException {
        if (runOnBrowserStack) {
//            setupBrowserStackDriver();
            System.out.println("AKu ada di browsertack");
        } else {
            setupLocalDriver();
            System.out.println("AKu ada di Local");
        }
    }

    private static void setupLocalDriver() throws FileNotFoundException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        // Configure local driver options
        // ...
        driver = new ChromeDriver(chromeOptions);

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().setScriptTimeout(Duration.ofMinutes(2));
        driver.manage().window().maximize();

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");

        try {
            properties.load(fileInputStream);
            String baseUrl = properties.getProperty("baseUrl");
            String expectedTitle = properties.getProperty("title");

            driver.get(baseUrl);
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle, "Page title doesn't match the expected title.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ...
    }


    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            // Capture a screenshot and attach it to your test report (e.g., using Allure)
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(screenshot));
        }
        driver.quit();
    }
}