package PageInteractions;
import PageObjects.AmazonTestPageObjects;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmazonTestInteractions {
    public WebDriver driver;
    WebDriverWait wait;
    public AmazonTestPageObjects amazonTestFunctionalityPageObjects;

    public AmazonTestInteractions(WebDriver driver) {
        this.driver = driver;
        amazonTestFunctionalityPageObjects = new AmazonTestPageObjects(this.driver);
    }

    public void selectDropDownandType(String optionType, String data){
        amazonTestFunctionalityPageObjects.searchBox.click();
        Select select= new Select(amazonTestFunctionalityPageObjects.searchDropdown);
        select.selectByVisibleText(optionType);
        amazonTestFunctionalityPageObjects.searchBox.sendKeys(data);
    }

    public void validateSuggestedResults(String data){
        for(WebElement content:amazonTestFunctionalityPageObjects.suggestedContent()){
            Assert.assertTrue(content.getText().toLowerCase().contains(data.toLowerCase()));
        }
    }

    public void selectPhoneVariant(String data,String variant){
        amazonTestFunctionalityPageObjects.searchBox.clear();
        amazonTestFunctionalityPageObjects.searchBox.sendKeys(data);
        String suggestedVarient=variant.toLowerCase();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        amazonTestFunctionalityPageObjects.selectFromSuggestion(suggestedVarient).click();
        amazonTestFunctionalityPageObjects.productResult.click();
    }


    public void switchToNewTab() {
        String parentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    public void clickVisitAppleStore() {
        amazonTestFunctionalityPageObjects.appleStoreLink.click();
    }

    String watchName,watchModel;

    public void selectAppleWatch(String variant) {
        amazonTestFunctionalityPageObjects.appleWatchDropdown.click();
        amazonTestFunctionalityPageObjects.getAppleWatchType(variant).click();
        Pattern pattern = Pattern.compile("\\((.*?)\\)");
        Matcher matcher = pattern.matcher(variant);
        if (matcher.find()) {
            watchModel = matcher.group(1);
            watchName = variant.replace(matcher.group(0), "");
        }
    }

    String watchType;

    public void hoverOnWatchImage() {
        Actions actions = new Actions(driver);
        watchType=amazonTestFunctionalityPageObjects.productText.getText();
        actions.moveToElement(amazonTestFunctionalityPageObjects.productImage)
                .moveToElement(amazonTestFunctionalityPageObjects.quickLook).build().perform();
        Assert.assertTrue(amazonTestFunctionalityPageObjects.quickLook.isDisplayed());
        amazonTestFunctionalityPageObjects.quickLook.click();
    }
    public void isQuickLookModalDisplayedCorrrectly() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String quickLookData=amazonTestFunctionalityPageObjects.quickLookHeading.getText();
        System.out.println("QuickLook Data: "+quickLookData);
        Assert.assertTrue(quickLookData.contains(watchName));
        Assert.assertTrue(quickLookData.contains(watchModel));
    }
}
