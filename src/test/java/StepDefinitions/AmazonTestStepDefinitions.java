package StepDefinitions;

import PageInteractions.AmazonTestInteractions;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AmazonTestStepDefinitions {
    WebDriver driver;

    AmazonTestInteractions interactions;

    @Given("I open Amazon in Chrome browser")
    public void iOpenAmazonInChromeBrowser() {
        System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        interactions = new AmazonTestInteractions(driver);
    }

    @When("I select {string} from the dropdown and type {string}")
    public void iSelectFromTheDropdownAndType(String optionType, String data) {
        interactions.selectDropDownandType(optionType, data);
    }

    @Then("I should see suggestions related to {string}")
    public void iShouldSeeSuggestionsRelatedTo(String data) {
        interactions.validateSuggestedResults(data);
    }

    @When("I type {string} and select the {string} variant from suggestions")
    public void iTypeAndSelectTheVariantFromSuggestions(String data,String variant) {
        interactions.selectPhoneVariant(data, variant);
    }


    @When("I navigate to the new tab and click on Visit the Apple Store link")
    public void iNavigateToTheNewTabAndClickOnLink() {
        interactions.switchToNewTab();
        interactions.clickVisitAppleStore();
    }

    @Then("I should select {string} from the dropdown")
    public void iShouldSelectFromTheDropdown(String variant) {
        interactions.selectAppleWatch(variant);
    }

    @And("I hover over the watch image and validate Quick Look modal is displayed")
    public void iHoverOverTheWatchImageAndValidateQuickLookModalIsDisplayed() {
        interactions.hoverOnWatchImage();
    }

    @Then("the modal should display details of the correct product")
    public void theModalShouldDisplayDetailsOfTheCorrectProduct() {
        interactions.isQuickLookModalDisplayedCorrrectly();
        driver.quit();
    }

}

