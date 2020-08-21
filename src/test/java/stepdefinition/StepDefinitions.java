package stepdefinition;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;
import pages.createTicketWindow;

import java.io.File;
import java.io.IOException;

public class StepDefinitions {
    @Before
    public void beforeCucumberScenario(Scenario scenario) {
        WebDriverFactory.createInstance("Chrome");
    }

    @After
    public void afterCucumberScenario(Scenario scenario) {
        if (scenario.getStatus().toString().contains("FAILED")) {
            try {
                takeScreenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        WebDriverFactory.getDriver().close();
    }

    public void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        File trgtFile = new File(System.getProperty("user.dir") + "//screenshots/screenshot.png");
        System.out.println("SAVING Screenshot to " + trgtFile.getAbsolutePath());
        trgtFile.getParentFile().mkdir();
        trgtFile.createNewFile();
        Files.copy(scrFile, trgtFile);
    }


    @Then("^I navigate to Jira Login Page$")
    public void navigateToLoginPage() {
        new LoginPage().navigateTo();
    }


    @Then("^I enter user name ([^\"]*)$")
    public void iEnterUserName(String login) {
        new LoginPage().enterUserName(login);
    }

//    @Then("^I enter user name - \"(.*?)\"$")
//    public void enterUserName(String userName) {
//        new LoginPage().enterUserName(userName);
//    }

    @Then("^I enter password ([^\"]*)$")
    public void iEnterPassword(String pass) {
       new LoginPage().enterPassword(pass);

    }
//    @Then("^I enter password - \"(.*?)\"$")
//    public void enterPassword(String password) {
//        new LoginPage().enterPassword(password);
//    }

    @Then("^I click on the login button$")
    public void clickLoginButton() {
        new LoginPage().clickLogin();
    }

    @When("^I am on the Home Page$")
    public void atTheHomePage() {
        assert new HomePage().onPage();
    }

    @When("^I debug$")
    public void debug() {
        int a = 0;
    }

    @Given("^I am on the main page$")
    public void iAmOnTheMainPage(){
        assert new HomePage().checkIfMainPageIsOpen();
    }

    @Then("^I will wait when my ticket will be opened$")
    public void mainPageIsFullyLoaded(){
        assert new HomePage().waitUntilOpenListOfAssignedTickets();
    }

    @Then("^I check is Create Ticket button is active$")
    public void checkIsCreateTicketButtonIsActive(){
        assert new HomePage().isCreateTicketButtonIsActive();
    }

    @Then("^I am waiting when main page will be fully loaded$")
    public void waitForMainPageLoading(){
        assert new HomePage().checkIfJiraMainPageIsFullyOpened();
    }

    @Then("^I click on the Create Issue button$")
    public void clickOnTheCreateIssueButton(){
        new HomePage().clickOnTheCreateButton();
    }

    @Then("^Create ticket window is open$")
    public void isCreateTicketWindowIsOpen(){
        assert new HomePage().checkIfCreateTicketWindowIsOpen();
    }

    @Then("^I will clear project name field$")
    public void clearTicketProjectField(){
        new createTicketWindow().clearTicketProjectField();
    }

    @Then("^I fill project name - \"(.*?)\"$")
    public void enterUserName(String projectName) {
        new createTicketWindow().ticketTypeProjectName(projectName);
    }

    @Then("^I press Tab$")
    public void pressTabForProjectField(){
        new createTicketWindow().ticketProjectFieldClickTabButton();
    }

    @Then("^I clear issue field$")
    public void clearIssueField() {
        new createTicketWindow().ticketClearIssueTypeField();
    }

    @Then("^I select issue type in the issue field - \"(.*?)\"$")
    public void selectIssueType(String issueType){
        new createTicketWindow().ticketSelectIssueType(issueType);
    }

    @Then("^I press Tab to go to the next field$")
    public void pressTabForIssueField(){
        new createTicketWindow().ticketIssueTypeFiledPresTabButton();
    }

    @Then("^I will check if Description field is active$")
    public void isDescriptionFieldIsActive(){
        assert new createTicketWindow().ticketWaitingForDescriptionWillBeActive();
    }

    @Then("^I will type summary of the ticket - \"(.*?)\"$")
    public void typeSummary(String summary){
        new createTicketWindow().ticketTypeSummary(summary);
    }

    @Then("^I click on the Save button$")
    public void clickOnTheSaveIssueButton(){
        new createTicketWindow().ticketCLickSaveTicketButton();
    }

    @Then("^I am waiting for success message$")
    public void ifSuccessMessageAppeared(){
        assert new createTicketWindow().checkIfSuccessPopUpIsPresent();
    }

    @Then("^I check is success message contains Webinar ticket type$")
    public void isSuccessMessageContainWebinarName(){
        assert new createTicketWindow().checkIfPopUpContainsWebinarName();
    }
}
