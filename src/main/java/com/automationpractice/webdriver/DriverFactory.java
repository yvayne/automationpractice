package com.automationpractice.webdriver;

import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * It is in charged to instantiate web driver.
 */
public final class DriverFactory {

    private static final Map<DriverType, Supplier<Browser>> BROWSER_MAP = new EnumMap<>(DriverType.class);
    static {
        BROWSER_MAP.put(DriverType.CHROME, ChromeBrowser::new);
        BROWSER_MAP.put(DriverType.FIREFOX, FirefoxBrowser::new);
    }

    /**
     * Private Constructor for the DriverFactory utility class.
     */
    private DriverFactory() {
    }

    /**
     * Return the WebDriver instance specified by the environment properties.
     *
     * @param driverType Enum value specified from DriverType.
     * @return a WebDriver instance.
     */
    public static WebDriver getDriverManager(final DriverType driverType) {
        return BROWSER_MAP.get(driverType).get().getBrowser();
    }
}
