package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonTestPageObjects {
    WebDriver driver;
    @FindBy(id="searchDropdownBox")
    public WebElement searchDropdown;

    @FindBy(id="twotabsearchtextbox")
    public WebElement searchBox;
    @FindBy(xpath="//div[@class='s-suggestion s-suggestion-ellipsis-direction']")
    public WebElement suggestionsList;

    @FindBy(xpath="(//span[contains(text(),'Apple iPhone 13 (128GB)')])[1]")
    public WebElement productResult;

    @FindBy(partialLinkText="Visit the Apple Store")
    public WebElement appleStoreLink;

    @FindBy(xpath="//span[text()='Apple Watch']//parent::a[@role='button']")
    public WebElement appleWatchDropdown;

    @FindBy(xpath="(//h3[@class='EditorialTileProduct__text__Ggktv'])[1]")
    public WebElement productText;

    @FindBy(xpath="(//div[@class='EditorialTileProduct__imageColumn__f4PXp'])[1]")
    public WebElement productImage;

    @FindBy(xpath="(//button[@class='QuickLook__container__cchE1 QuickLook__container--showing-text__peGBL EditorialTileProduct__quickLook__cRlkW'])[1]")
    public WebElement quickLook;

    @FindBy(xpath="//a[@class='ProductShowcase__title__SBCBw']")
    public WebElement quickLookHeading;

    public AmazonTestPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        System.out.println("Driver is not null");
    }
    public List<WebElement> suggestedContent(){
        return driver.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
    }

    public WebElement selectFromSuggestion(String suggestedVarient){
        return driver.findElement(By.xpath("//span[text()='" + suggestedVarient + "']"));
    }

    public WebElement getAppleWatchType(String watchType){
        return driver.findElement(By.xpath("//span[text()='"+watchType+"']//parent::a"));
    }
}
