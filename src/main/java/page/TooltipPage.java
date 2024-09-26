package page;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TooltipPage {

    WebDriver driver;

    WebDriverWait wait;

    @FindBy(xpath = "//a[@href='/login/']")
    WebElement loginToolTipEle;

    @FindBy(xpath = "//img[@class='_97vu img']")
    WebElement fbLogo;

    public TooltipPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
    }

    public String getTipMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginToolTipEle));
        return loginToolTipEle.getAttribute("title");
    }

    public void openFbLoginPage(String fbUrl){
        driver.get(fbUrl);
    }

    public void getScOfFbPage(File dest) throws IOException {
        TakesScreenshot tc = (TakesScreenshot) driver;
       File file = tc.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(file, dest);
    }

    public void getScOfFbLogo(File dest) throws IOException {
        File file = fbLogo.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(file, dest);
    }


}
