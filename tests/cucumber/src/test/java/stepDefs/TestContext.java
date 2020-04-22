package stepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestContext {

    private WebDriver driver;

    final String DRIVER_PATH = "chromedriver";

    @Before
    public void initialiseMainElements(){
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
    }

    @After
    public void closeDriver(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
