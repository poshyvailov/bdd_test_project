package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomePage {



    private By createButton = By.xpath("//li[@id='create-menu']");
    private By searchTicketField = By.id("quickSearchInput");


    public boolean onPage(){
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        return wait.until(presenceOfElementLocated(By.id("browse_link"))).isDisplayed();
    }



    public boolean checkIfMainPageIsOpen() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        return wait.until(presenceOfElementLocated(By.xpath("//*[@id='dashboard-content']//h1"))).isDisplayed();
    }

    public boolean waitUntilOpenListOfAssignedTickets() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        return wait.until(presenceOfElementLocated(By.xpath("//*[@class='date-header' and contains(text(), 'Today')]"))).isDisplayed();
    }

    public boolean isCreateTicketButtonIsActive() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        return wait.until(elementToBeClickable(createButton)).isEnabled();
    }

    public boolean checkIfJiraMainPageIsFullyOpened() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        return wait.until(elementToBeClickable(By.id("browse_link"))).isEnabled();
    }

    public void clickOnTheCreateButton() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        wait.until(elementToBeClickable(createButton)).isEnabled();
        WebDriverFactory.getDriver().findElement(createButton).click();
    }

    public boolean checkIfCreateTicketWindowIsOpen() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        return wait.until(presenceOfElementLocated(By.xpath("//h2[@title='Create Issue']"))).isDisplayed();
    }

    public boolean waitingWhenSearchFieldWillAppear() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15).getSeconds());
        return wait.until(presenceOfElementLocated(searchTicketField)).isDisplayed();
    }

    public void typeTicketNameToSearch(String ticketName) {
        WebDriverFactory.getDriver().findElement(searchTicketField).sendKeys(ticketName);
    }

    public void pressEnterForSearchField() {
        WebDriverFactory.getDriver().findElement(searchTicketField).sendKeys(Keys.ENTER);
    }


}
