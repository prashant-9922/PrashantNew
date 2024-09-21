package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.*;
import org.testng.Assert;
import page.LoginPage;

import java.sql.DriverManager;
import java.util.List;

import factory.DriverFactory;

public class LoginPageStepDef {

    String title;

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    public static Logger logger = LogManager.getLogger(LoginPageStepDef.class);

    @When("open login page")
    public void openLoginPage(DataTable dataTable) {
        List<String> expDataList = dataTable.asList();
        loginPage.openLoginPage(expDataList.get(0));
    }

    @And("get title of fb page")
    public void getTitleOfFbPage() {
        title = loginPage.getTitle();
        logger.info("Fb login page title is " + title);
    }

    @Then("verify login page is opened successfully")
    public void verifyLoginPageIsOpenedSuccessfully() {
        Assert.assertEquals(title,"Log in to Facebook");
        logger.info("Fb login page open successfully");
        loginPage.closeBrowser();
        logger.info("Browser close successfully");
    }
}
