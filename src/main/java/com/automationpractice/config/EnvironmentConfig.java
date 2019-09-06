package com.automationpractice.config;

import java.util.Objects;

/**
 * It is in charge to read the environment variables.
 */
public final class EnvironmentConfig {

    private static final String PROP_FILE = "gradle.properties";
    private static final String BROWSER = "browser";
    private static final String IMPLICIT_TIME_WAIT = "implicitTimeWait";
    private static final String EXPLICIT_TIME_WAIT = "explicitTimeWait";
    private static EnvironmentConfig instance;

    private PropertiesReader propertiesReader;

    /**
     * Initializes an instance of {@link EnvironmentConfig}.
     */
    private EnvironmentConfig() {
        propertiesReader = new PropertiesReader(PROP_FILE);
    }

    /**
     * Initializes the Singleton {@link EnvironmentConfig} instance.
     *
     * @return singleton instance.
     */
    public static synchronized EnvironmentConfig getInstance() {
        if (Objects.isNull(instance)) {
            instance = new EnvironmentConfig();
        }
        return instance;
    }

    /**
     * Gets browser.
     *
     * @return browser value.
     */
    public String getBrowser() {
        return propertiesReader.getEnv(BROWSER);
    }

    /**
     * Gets implicit time wait.
     *
     * @return implicit time wait value.
     */
    public int getImplicitTime() {
        return Integer.parseInt(propertiesReader.getEnv(IMPLICIT_TIME_WAIT));
    }

    /**
     * Gets explicit time wait.
     *
     * @return explicit time wait.
     */
    public int getExplicitTime() {
        return Integer.parseInt(propertiesReader.getEnv(EXPLICIT_TIME_WAIT));
    }
}
