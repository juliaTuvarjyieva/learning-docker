package com.jcg.selenium.utils;

public class AuthStorage {

    private static final String RUN_DOCKER = "runDocker";

    private static final String AUT_PROPERTIES = "config.properties";

    public static String getFromEnv(String envName) {
        String autEnv = System.getenv(envName);
        if (autEnv != null && !autEnv.isEmpty()) {
            return autEnv;
        }
        return null;
    }

    public static String getFromFile(String key) {
        return PropertyReader.getInstance().getProperty(AUT_PROPERTIES, key);
    }

    public static String getProperty(String property) {
        String fromEnv = System.getProperty(property);
        if (System.getProperty(property) == null) {
            fromEnv = getFromEnv(property);
        }
        String value = fromEnv != null ? fromEnv : getFromFile(property);
        return value;
    }

    public static Boolean isDockerRun() {
        return Boolean.parseBoolean(getProperty(RUN_DOCKER));
    }
}
