package com.automationpractice.pages;

import com.automationpractice.pages.base.BasePage;
import org.openqa.selenium.By;

/**
 * Represents the home page.
 */
public class HomePage extends BasePage {

    private static final String CSS_TAB = "a[title='%s']";

    /**
     * Helps to select a tab in home page.
     *
     * @param tabName tab name to select.
     */
    public void selectTab(final String tabName) {
        webDriver.findElement(By.cssSelector(String.format(CSS_TAB, tabName))).click();
    }
}
