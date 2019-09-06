package com.automationpractice.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Instantiates Chrome driver.
 */
public class ChromeBrowser implements Browser {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriverManager.chromedriver().version("75.0.3770.90").setup();
        return new ChromeDriver();
    }
}
