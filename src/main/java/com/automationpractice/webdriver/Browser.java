package com.automationpractice.webdriver;

import org.openqa.selenium.WebDriver;

/**
 * Defines web driver abstraction.
 */
@FunctionalInterface
public interface Browser {

    /**
     * This method return a Web Driver instance of a specified browser.
     *
     * @return the Web Driver instance.
     */
    WebDriver getBrowser();
}
