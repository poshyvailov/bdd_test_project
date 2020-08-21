package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class createTicketWindow {

    private By ticketProjectField = By.id("project-field");
    private By ticketIssueTypeField = By.id("issuetype-field");
    private By ticketSummaryField = By.id("summary");
    private By saveTicketButton = By.id("create-issue-submit");


    public void clearTicketProjectField() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        wait.until(elementToBeClickable(ticketProjectField)).isEnabled();
        WebDriverFactory.getDriver().findElement(ticketProjectField).clear();
    }

    public void ticketTypeProjectName(String name) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        wait.until(elementToBeClickable(ticketProjectField)).isEnabled();
        WebDriverFactory.getDriver().findElement(ticketProjectField).sendKeys(name);
    }

    public void ticketProjectFieldClickTabButton() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        wait.until(elementToBeClickable(ticketProjectField)).isEnabled();
        WebDriverFactory.getDriver().findElement(ticketProjectField).sendKeys(Keys.TAB);
    }


    public void ticketClearIssueTypeField() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        wait.until(elementToBeClickable(ticketIssueTypeField)).isEnabled();
        WebDriverFactory.getDriver().findElement(ticketIssueTypeField).clear();
    }

    public void ticketSelectIssueType(String issueType) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        wait.until(elementToBeClickable(ticketIssueTypeField)).isEnabled();
        WebDriverFactory.getDriver().findElement(ticketIssueTypeField).sendKeys(issueType);
    }

    public void ticketIssueTypeFiledPresTabButton() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        wait.until(elementToBeClickable(ticketIssueTypeField)).isEnabled();
        WebDriverFactory.getDriver().findElement(ticketIssueTypeField).sendKeys(Keys.TAB);
    }

    public boolean ticketWaitingForDescriptionWillBeActive() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        return wait.until(elementToBeClickable(By.id("description"))).isEnabled();
    }

    public void ticketTypeSummary(String summary) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        wait.until(elementToBeClickable(ticketSummaryField)).isEnabled();
        WebDriverFactory.getDriver().findElement(ticketSummaryField).sendKeys(summary);
    }

    public void ticketCLickSaveTicketButton() {
        WebDriverFactory.getDriver().findElement(saveTicketButton).click();
    }

    public boolean checkIfSuccessPopUpIsPresent() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        return wait.until(presenceOfElementLocated(By.id("aui-flag-container"))).isDisplayed();
    }

    public boolean checkIfPopUpContainsWebinarName() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        return wait.until(presenceOfElementLocated(By.xpath("//*[@id='aui-flag-container']//a[contains (text(), 'WEBINAR')]"))).isDisplayed();


    }
}
