package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    WebDriverWait wait;

    public Logger logger = LogManager.getLogger(this);

    @FindBy (xpath = "//input[@id='email']")
    private WebElement userName;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void openLoginPage(String url){
        driver.get(url);
        logger.info("fb url send successfully");
    }

    public String getTitle(){
        wait.until(ExpectedConditions.visibilityOf(userName));
        return driver.getTitle();
    }

    public void closeBrowser(){
        driver.close();
    }


}
