package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class LoginSteps {
    private String message ="¡Hola, caso!";

    LoginPage login = new LoginPage();

    @Given("navigate the paris page")
    public void navigateTheParisPage() {
        login.navigateParisHome();
    }

    @When("click on the login button")
    public void clickLoginButtonP() {
        login.hoverOverButton();
        login.clickLoginButton();
    }

    @Then("enter your email")
    public void enterEmailP() {
       login.enterEmail("testingqa065@gmail.com");
    }

    @Then("enter your password")
    public void enterPassP() {
        login.enterPassword("Testing2023");
    }

    @And("click on the enter button")
    public void clickEnterButtonP() {
        login.clickEnterButton();
        login.waitElementP();
    }

    @Then("see the welcome message")
    public void validateMessageP() {
       Assert.assertEquals(message, login.validateMessage());
    }
}
