package driverManage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class driverManager {
    private static WebDriver driver;

    @Before
    public void setUp() {
        try {

            if (driver == null) {
                System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                System.out.println("WebDriver initialized successfully");
            } else {
                System.out.println("WebDriver already initialized");
            }
        }
        catch(Exception e){
           System.out.println("Error initializing WebDriver:"+e.getMessage());
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    public static WebDriver getDriver() {
        return driver;
    }

}
