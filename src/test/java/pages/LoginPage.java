package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends MainPage {
    private String loginButton = "/html/body/header/div[2]/div/nav/div[3]/div/div/div[1]/div/div/div/div/div/div[1]/button";
    private String btn = "/html/body/header/div[2]/div/nav/div[3]/div/div/div[1]/div";
    private String enterEmail = "//*[@id=\'dwfrm_login_username\']";
    private String enterPass = "//*[@id=\'dwfrm_login_password\']";
    private String enterButton = "//button[@class='btn btn--primary']";
    private String validateMessage = "/html/body/header/div[2]/div/nav/div[3]/div/div/div[1]/div/button/div[2]/div[1]";


    public LoginPage() {
        super(driver);
    }

    public void navigateParisHome() {
        navigateTo("https://www.paris.cl/");
    }

    public void hoverOverButton() {
        hoverOverElement(btn);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public void enterEmail(String criteria) {
        write(enterEmail, criteria);
    }

    public void enterPassword(String criteria) {
        write(enterPass, criteria);
    }

    public void clickEnterButton() {
        clickElement(enterButton);
      }

    public void waitElementP() {
        waitElement(enterButton);
    }

    public String validateMessage() {
        return textFromElement(validateMessage);
    }
}
