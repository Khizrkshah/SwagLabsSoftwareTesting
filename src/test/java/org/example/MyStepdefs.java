package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {

    private static final int WAIT_TIME = 10;

    static WebDriver driver;

    protected static HomePage homePage;

    static {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        //options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
        /*
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
         */
        homePage = new HomePage(driver);


    }

    @And("the Password is filled with {string}")
    public void thePasswordIsFilledWithSecret_sauce(String password) {
        homePage.fillField(HomePage.PASSWORD,password);
    }

    @Given("the homepage is open")
    public void theHomepageIsOpen() {
        homePage.openPage();
    }

    @And("the Username is filled with {string}")
    public void theUsernameIsFilledWithStandard_user(String userName) {
        homePage.fillField(HomePage.USERNAME,userName);
    }

    @And("the Login button is clicked")
    public void theLoginButtonIsClicked() {
        homePage.clickLoginButton();
    }

    @Given("the Sauce Labs Backpack is added to the cart")
    public void theSauceLabsBackpackIsAddedToTheCart() {
        homePage.addBackpackToCart();
    }

    @And("the cart icon is clicked")
    public void theCartIconIsClicked() {
        homePage.clickOnCart();
    }

    @And("the checkout button is clicked")
    public void theCheckoutButtonIsClicked() {
        homePage.clickCheckoutButton();
    }

    @And("the First Name is filled with {string}")
    public void theFirstNameIsFilledWithA(String firstName) {
        homePage.fillField(HomePage.FIRSTNAME,firstName);
    }

    @And("the Last Name is filled with {string}")
    public void theLastNameIsFilledWithB(String lastName) {
        homePage.fillField(HomePage.LASTNAME,lastName);
    }

    @And("the Zip Code is filled with {string}")
    public void theZipCodeIsFilledWith(String postalCode) {
        homePage.fillField(HomePage.POSTAL_CODE,postalCode);
    }

    @When("the Continue button is clicked")
    public void theContinueButtonIsClicked() {
        homePage.clickContinueButton();
    }

    @Then("{string} should be shown")
    public void total$ShouldBeShown(String total) {
        Assert.assertEquals(total, homePage.getTotal());
    }
}
