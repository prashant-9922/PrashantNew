import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(

        features = "/Users/apple/IdeaProjects/CucumberDemo/src/test/java/Features",
        glue = "/Users/apple/IdeaProjects/CucumberDemo/src/test/java/steps",
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber-reports.html" }
)



public class TestRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
