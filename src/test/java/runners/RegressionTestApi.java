package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = {"stepdefinations.api", "hooks", "context"},
        monochrome = true,
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        tags = "@api and @regression"

)
public class RegressionTestApi extends AbstractTestNGCucumberTests {
}
