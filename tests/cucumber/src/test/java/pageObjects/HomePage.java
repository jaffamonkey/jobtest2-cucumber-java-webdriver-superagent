package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage {

    final String WEB_URL = "https://coinmarketcap.com";

    protected WebDriver driver;

    @FindBy(id = "signin_button")
    private WebElement singInButton;

    @FindBy(xpath = "//*[@id=\"settingsBox\"]/ul/li[3]/a ")
    private WebElement userContextMenuLink;

    @FindBy(id = "logout_link")
    private WebElement logOutLink;

    @FindBy(css = "svg.fa-star")
    private WebElement watchLink;

    @FindBy(linkText = "Watchlist")
    private WebElement watchList;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/ul[1]/li[1]/div/div/span")
    private WebElement cryptocurrenciesList;

    @FindBy(xpath = "//*[@id=\"cmc-cookie-policy-banner\"]/div[2]")
    private WebElement cookieOverlay;

    @FindBy(css = "div[data-qa-id=\"range-filter-price\"]")
    private WebElement priceLink;

    @FindBy(css = "div[data-qa-id=\"range-filter-circSupply\"]")
    private WebElement supplyLink;

    @FindBy(css = "div[data-qa-id=\"range-filter-volume\"]")
    private WebElement volumeLink;

    @FindBy(css = "input[name=\"priceMin\"]")
    private WebElement priceField;

    @FindBy(css = "input[name=\"circSupplyMin\"]")
    private WebElement supplyField;

    @FindBy(css = "input[name=\"volumeMin\"]")
    private WebElement volumeField;

    @FindBy(css = "button[data-qa-id=\"filter-dd-button-apply\"]")
    private WebElement applyFilter;

    @FindBy(css = "button[data-qa-id=\"table-listing-filters-toggle\"]")
    private WebElement filterLink;

    @FindBy(className = "cmc-logo-link")
    private WebElement homePage;

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Click user to make context menu appear
    public void clickHomepageTextLink() {
        driver.get("https://coinmarketcap.com");
    }

    // Click user to make context menu appear
    public void selectRandomCurrencies(int count) {
        driver.findElement(By.linkText("Bitcoin")).click();
        driver.findElement(By.cssSelector("svg.fa-star")).click();
        clickHomepageTextLink();
        driver.findElement(By.linkText("Ethereum")).click();
        driver.findElement(By.cssSelector("svg.fa-star")).click();
        clickHomepageTextLink();
        driver.findElement(By.linkText("XRP")).click();
        driver.findElement(By.cssSelector("svg.fa-star")).click();
        clickHomepageTextLink();
        driver.findElement(By.linkText("Tether")).click();
        driver.findElement(By.cssSelector("svg.fa-star")).click();
        clickHomepageTextLink();
        driver.findElement(By.linkText("Bitcoin Cash")).click();
        driver.findElement(By.cssSelector("svg.fa-star")).click();
        clickHomepageTextLink();
    }

    public void closeCookieOverlay() {
        cookieOverlay.click();
    }

    public void clickWatchlistTextLink() {
        driver.get("https://coinmarketcap.com/watchlist/");
    }

    public void clickPriceLink() {
        priceLink.click();
    }

    public void clickSupplyLink() {
        supplyLink.click();
    }

    public void clickVolumeLink() {
        volumeLink.click();
    }

    public void filterApply() {
        applyFilter.click();
    }

    public void clickFilter() {
        filterLink.click();
    }

    public void enterPriceFilter(String input) {
        priceField.sendKeys(input);
    }

    public void enterSupplyFilter(String input) {
        supplyField.sendKeys(input);
    }

    public void enterVolumeFilter(String input) {
        volumeField.sendKeys(input);
    }

    // Click the log out button ( ONLY on context menu )
    public void checkResultCount(int count) {
        int eleCount = driver.findElements(By.className("cmc-table-row")).size();
        Assert.assertEquals(eleCount, count);
    }

}
