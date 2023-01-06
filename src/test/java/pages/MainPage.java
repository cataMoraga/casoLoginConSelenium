package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainPage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;


    static {
        System.setProperty("webdriver.chrome.driver", "src/main/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // navegar por una url
    public static void navigateTo(String url) {
        driver.get(url);
    }

    // cerrar navegador
    public static void closeBrowser() {
        driver.quit();
    }

    // encontrar un elemento web
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitElement(String locator) {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(Find(locator)));
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    // dar click
    public void clickElement(String locator) {
        Find(locator).click();
    }

    // escribir texto
    public void write(String locator, String textToWrite) {
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    // hover over (mover el mouse por la pantalla)
    public void hoverOverElement(String locator) {
        actions = new Actions(driver);
        actions.moveToElement(Find(locator)).build().perform();
    }

    // validar texto
    public String textFromElement(String locator) {
        return Find(locator).getText();
    }
}
