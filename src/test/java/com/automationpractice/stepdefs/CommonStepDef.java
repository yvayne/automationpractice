package com.automationpractice.stepdefs;

import com.automationpractice.webdriver.DriverManager;
import cucumber.api.java.en.Given;

/**
 * Common steps.
 */
public class CommonStepDef {

    /**
     * This steps helps to navigate.
     *
     * @param url url to navigate.
     */
    @Given("I go to : {string}")
    public void iGoTo(final String url) {
        DriverManager.getInstance().getWebDriver().get(url);
    }

}
