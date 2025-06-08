package com.epam.greenandtasty.runners.ui;

import com.epam.greenandtasty.listeners.APITestExecutionListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = "src/test/resources/features/ui",
        glue = {"com.epam.greenandtasty.stepdefinitions.ui", "com/epam" +
                "/greenandtasty/hooks"},
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true,
        tags = "@smoke"
)

@Listeners(APITestExecutionListener.class)
public final class UISmokeRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
