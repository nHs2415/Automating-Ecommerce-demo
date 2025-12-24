package stepDefinitions;

import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

public class Steps {
    public WebDriver driver;
    public LoginPage lp;

    @Given("User Launch Chrome Browser")
    public void user_launch_chrome_browser() {
            driver = new ChromeDriver();
            lp = new LoginPage(driver);
    }

    @When("User opes URL {string}")
    public void user_opes_url(String url) {
        driver.get(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password){
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() {
        lp.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        }else{
            Assert.assertEquals(title, driver.getTitle());
        }
    }

    @When("User clicks on Logout link")
    public void user_clicks_on_logout_link() {
        lp.clickLogout();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("Close the browser")
    public void close_the_browser() {
        driver.quit();
    }


}