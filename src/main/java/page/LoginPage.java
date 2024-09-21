package page;

import io.github.bonigarcia.wdm.WebDriverManager;
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


    @FindBy (xpath = "//input[@id='email']")
    private WebElement userName;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void openLoginPage(String url){
        driver.get(url);
    }

    public String getTitle(){
        wait.until(ExpectedConditions.visibilityOf(userName));
        return driver.getTitle();
    }

    public void closeBrowser(){
        driver.close();
    }


}
