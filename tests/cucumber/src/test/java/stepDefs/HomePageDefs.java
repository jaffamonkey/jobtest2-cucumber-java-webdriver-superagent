package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class HomePageDefs {

    private WebDriver driver;
    final String WEB_URL = "https://coinmarketcap.com";

    private HomePage objHomePage;

    public HomePageDefs(TestContext testContext) {
        this.driver = testContext.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        objHomePage = new HomePage(driver);
    }

    @Given("^I open page \"([^\"]*)\"$")
    public void i_open_page(String pageName) {
        switch (pageName) {
            case "Homepage":
                objHomePage.clickHomepageTextLink();
                break;
            case "Watchlist":
                objHomePage.clickWatchlistTextLink();
                break;
        }
    }

    @When("^I click \"([^\"]*)\"$")
    public void i_click(String linkText) throws Throwable {
        switch (linkText) {
            case "Homepage":
                objHomePage.clickHomepageTextLink();
                break;
            case "Watchlist":
                objHomePage.clickWatchlistTextLink();
                break;
        }
    }

    @Then("^a (\\d+) results are displayed$")
    public void a_results_are_displayed(int count) throws Throwable {
        objHomePage.checkResultCount(count);
    }

    @Given("^I add (\\d+) random cryptocurrencies to the watchlist$")
    public void i_add_random_cryptocurrencies_to_watchlist(int count) throws Throwable {
        objHomePage.selectRandomCurrencies(count);
    }

    @Then("^(\\d+) newly added cryptocurrencies are visible in the watchlist$")
    public void newly_added_cryptocurrencies_are_visible_in_the_watchlist(int count) throws Throwable {
        objHomePage.checkResultCount(count);
    }

    @Given("^I click the Full List option$")
    public void i_click_the_Full_List_option() throws Throwable {
        objHomePage.clickWatchlistTextLink();
    }

    @Given("^I click the list filter button$")
    public void i_click_the_list_filter_button() throws Throwable {
        objHomePage.clickFilter();
    }
    

    @Given("^I close cookie overlay")
    public void i_close_cookie_overlay() throws Throwable {
        objHomePage.closeCookieOverlay();
    }

    @When("^I select \"([^\"]*)\" from filter \"([^\"]*)\"$")
    public void i_select_from_filter(String arg1, String arg2) throws Throwable {
        switch (arg2) {
            case "price":
                objHomePage.clickPriceLink();
                objHomePage.enterPriceFilter(arg1);
                objHomePage.filterApply();
                objHomePage.waitForPageLoaded();
                break;
            case "volume":
                objHomePage.clickVolumeLink();
                objHomePage.enterVolumeFilter(arg1);
                objHomePage.filterApply();
                objHomePage.waitForPageLoaded();
                break;
            case "circulating supply":
                objHomePage.clickSupplyLink();
                objHomePage.enterSupplyFilter(arg1);
                objHomePage.filterApply();
                objHomePage.waitForPageLoaded();
                break;
        }
    }

    @Then("^I should see list updated to (\\d+) rows$")
    public void i_should_see_list_updated_to_rows(int count) throws Throwable {
        objHomePage.checkResultCount(count);
    }

}
