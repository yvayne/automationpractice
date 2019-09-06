package com.automationpractice.webdriver;


import com.automationpractice.config.EnvironmentConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Manages web driver instance.
 */
public final class DriverManager {

    private static final int IMPLICIT_TIME_WAIT = EnvironmentConfig.getInstance().getImplicitTime();
    private static final int EXPLICIT_TIME_WAIT = EnvironmentConfig.getInstance().getExplicitTime();
    private static DriverManager instance;

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    /**
     * This method is the constructor class.
     */
    private DriverManager() {
        DriverType driverType = DriverType.valueOf(EnvironmentConfig.getInstance().getBrowser().toUpperCase());
        webDriver = DriverFactory.getDriverManager(driverType);
        webDriver.manage().window().maximize();
        restorePreviousTimeWait();
    }

    /**
     * This method instance the singleton object.
     *
     * @return singleton instance.
     */
    public static DriverManager getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * Gets web driver.
     *
     * @return web driver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Gets web Driver Wait.
     *
     * @return Web Driver Wait.
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    /**
     * Sets implicit time wait.
     *
     * @param implicitTimeWait implicit time wait.
     */
    public void setImplicitTimeWait(final int implicitTimeWait) {
        webDriver.manage().timeouts().implicitlyWait(implicitTimeWait, TimeUnit.SECONDS);
    }

    /**
     * Sets explicit time wait.
     *
     * @param explicitTimeWait explicit time wait.
     */
    public void setExplicitTimeWait(final int explicitTimeWait) {
        webDriverWait = new WebDriverWait(webDriver, explicitTimeWait);
    }

    /**
     * Updates explicit and implicit time wait.
     *
     * @param time time wait.
     */
    public void updateTimeWait(final int time) {
        setImplicitTimeWait(time);
        setExplicitTimeWait(time);
    }

    /**
     * Restores back previous wait.
     */
    public void restorePreviousTimeWait() {
        setImplicitTimeWait(IMPLICIT_TIME_WAIT);
        setExplicitTimeWait(EXPLICIT_TIME_WAIT);
    }
}

