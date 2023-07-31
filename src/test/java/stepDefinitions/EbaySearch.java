package stepDefinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class EbaySearch {

    WebDriver driver;

    @Given("I launch chrome browser")
    public void iLaunchChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/rpkumar/eclipse-workspace/SeleniumPractice/chromedriver");
        driver = new ChromeDriver();
    }

    @When("I open Ebay homepage")
    public void iOpenEbayHomepage() {

        //Navigate to Ebay Website
        driver.get("https://www.ebay.com/");
    }

    @Then("I verify that the logo is present on the page")
    public void iVerifyTheLogo() {

        //Verify that Ebay logo is present
        boolean img = driver.findElement(By.xpath("//*[@id=\"gh-logo\"]")).isDisplayed();
        Assert.assertEquals(true, img);

    }

    @Then("I navigate to cell phones and smartphones")
    public void iClickOnShopByCategory() {
        // Click on the "Shop by category" button
        driver.findElement(By.id("gh-shop-a")).click();

        // Click on the desired category link
        driver.findElement(By.xpath("//*[@id=\"gh-sbc\"]/tbody/tr/td[1]/ul[2]/li[4]/a")).click();

        // Verify that the selected category is displayed
        boolean cell = driver.findElement(By.xpath("//a[text()=\"Cell Phones & Smartphones\"]")).isDisplayed();
        Assert.assertEquals(true, cell);

        // Click on the "Cell Phones & Smartphones" category link
        driver.findElement(By.xpath("//a[text()=\"Cell Phones & Smartphones\"]")).click();

        // Click on the button to view items in the category
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/section[1]/div[1]/div[2]/button/span[1]")).click();

        // Wait for the elements to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Then("I apply the filters")
    public void iApplyTheFilters() {
        // Click on the "Screen Size" filter
        driver.findElement(By.xpath("//span[text()=\"Screen Size\"]")).click();

        // Wait for the elements to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Select the "6 in or More" filter
        driver.findElement(By.xpath("//span[text()=\"6 in or More\"]")).click();

        // Verify that the selected filter is displayed
        boolean size = driver.findElement(By.xpath("//span[@data-aspectfilter=\"Screen20Size_620in20or20More\"]"))
                .isDisplayed();
        Assert.assertEquals(true, size);

        // Wait for the elements to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Click on the "price" filter
        driver.findElement(By.xpath("//div[@data-aspecttitle=\"price\"]")).click();

        // Wait for the elements to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Enter the minimum value for price
        driver.findElement(By.xpath("//input[@aria-label=\"Minimum Value, US Dollar\"]"))
                .sendKeys("100");

        // Find the input field for maximum value and enter the value
        WebElement maxValue = driver.findElement(By.xpath("//input[@aria-label=\"Maximum Value, US Dollar\"]"));
        maxValue.sendKeys("200");

        // Press Enter to apply the price range filter
        maxValue.sendKeys(Keys.ENTER);

        // Verify that the price range is displayed
        boolean price = driver.findElement(By.xpath("//span[contains(text(),'$100 - $200')]")).isDisplayed();
        Assert.assertEquals(true, price);

        // Click on the "location" filter
        driver.findElement(By.xpath("//div[@data-aspecttitle=\"location\"]")).click();

        // Wait for the elements to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Select the "Worldwide" location filter
        driver.findElement(By.xpath("//input[@aria-label=\"Worldwide\"]")).click();

        // Verify that the selected location filter is displayed
        boolean location = driver.findElement(By.xpath("//span[@data-aspectfilter=\"location_2\"]"))
                .isDisplayed();
        Assert.assertEquals(true, location);

        // Click on the "Apply" button to apply the filters
        driver.findElement(By.xpath("//button[text()=\"Apply\"]")).click();
    }



    @Then("I search for MacBook")
    public void iSearchForMacBook() {

        // Type search string in the search bar
        WebElement searchInput = driver.findElement(By.name("_nkw"));
        searchInput.sendKeys("MacBook");

        // Change the search category
        WebElement categoryDropdown = driver.findElement(By.id("gh-cat"));
        categoryDropdown.sendKeys("Computers/Tablets & Networking");

        // Click the search button
        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        // Assert that the search results page is displayed
        WebElement searchResults = driver.findElement(By.id("srp-river-results"));
        Assert.assertTrue(searchResults.isDisplayed());

    }

    @Then("I ensure the page loads completely")
    public void iEnsureThePageLoads() {

        // Verify that the page loads completely
        WebElement searchResults = driver.findElement(By.id("srp-river-results"));
        if (searchResults.isDisplayed()) {
            System.out.println("Page loaded successfully.");
        } else {
            System.out.println("Page failed to load.");
        }

    }

    @Then("I verify that the first result name matches with the search string")
    public void iVerifySearchString() {

        // Verify that the first result name matches with the search string
        WebElement firstResultName = driver.findElement(By.cssSelector(".s-item__title"));
        String firstResultText = firstResultName.getText();
        if (firstResultText.contains("MacBook")) {
            System.out.println("First result name matches the search string.");
        } else {
            System.out.println("First result name does not match the search string.");
        }
    }

    @Then("close the browser")
    public void closeTheBrowser() {
        driver.quit();
    }
}