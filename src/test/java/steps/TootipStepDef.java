package steps;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import page.TooltipPage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TootipStepDef {

    String tipMessage;

    TooltipPage tooltipPage = new TooltipPage(DriverFactory.getDriver());
    
    private static Logger logger = LogManager.getLogger(TootipStepDef.class);
    
    @Given("open fb login page")
    public void openFbLoginPage(DataTable dataTable) {
        List<String> expDataList = dataTable.asList();
        tooltipPage.openFbLoginPage(expDataList.get(0));
        logger.info("Successfully open login page");
    }

    @Then("get tool tip of log in link at bottom")
    public void getToolTipOfLogInLinkAtBottom() {
       tipMessage = tooltipPage.getTipMessage();
       logger.info("Tool tip message is "+tooltipPage);
    }


    @Then("verify tool tip message")
    public void verifyToolTipMessage(DataTable dataTable) {
        List<String> expDataList = dataTable.asList();
        Assert.assertEquals(tipMessage, expDataList.get(0));
        logger.info("Tool tip message is verified");
    }

    @Then("get screenshot of fb page")
    public void getScreenshotOfFbPage(DataTable dataTable)throws IOException {
        List<String> expDataList = dataTable.asList();
        File file = new File(expDataList.get(0));
        tooltipPage.getScOfFbPage(file);
    }

    @Then("get screenshot of fb logo")
    public void getScreenshotOfFbLogo(DataTable dataTable)throws IOException {
        List<String> expDataList = dataTable.asList();
        File file = new File(expDataList.get(0));
        tooltipPage.getScOfFbLogo(file);
    }
}
