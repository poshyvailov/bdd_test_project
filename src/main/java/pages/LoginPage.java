package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginPage {

    private By userNameInput = By.id("login-form-username");
    private By passwordInput = By.id("login-form-password");
    private By loginButton = By.id("login");

    public void enterUserName(String name) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        wait.until(elementToBeClickable(userNameInput)).isEnabled();
        WebDriverFactory.getDriver().findElement(userNameInput).clear();
        WebDriverFactory.getDriver().findElement(userNameInput).sendKeys(name);
    }

    public void enterPassword(String password) {
        WebDriverFactory.getDriver().findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        wait.until(elementToBeClickable(loginButton)).isEnabled();
        WebDriverFactory.getDriver().findElement(loginButton).click();
    }

    public void navigateTo() {
        WebDriverFactory.getDriver().get("https://jira.hillel.it/secure/Dashboard.jspa");
    }
}