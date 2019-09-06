package com.automationpractice.runner;

import com.automationpractice.webdriver.DriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;

/**
 * It is in charged to define the Cucumber Runner class.
 */
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/"},
        glue = {"com.automationpractice"})
public class Runner extends AbstractTestNGCucumberTests {

    /**
     * Closes the web driver after the test was executed.
     */
    @AfterTest
    public void closeBrowser() {
        DriverManager.getInstance().getWebDriver().quit();
    }
}
