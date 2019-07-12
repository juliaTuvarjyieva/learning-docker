package com.jcg.selenium.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {

    private static Map<String, Properties> properties = new HashMap<>();

    private static PropertyReader instance;

    private PropertyReader() {

    }

    public static PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader();
        }
        return instance;
    }

    public Properties getProperties(String fileName) {
        if (!properties.containsKey(fileName)) {
            Properties props = new Properties();
            FileReader fileReader = null;
            try {
                fileReader = new FileReader(new File(fileName));
                props.load(fileReader);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage(), e);
            } finally {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                }
            }

            properties.put(fileName, props);
        }
        return properties.get(fileName);
    }

    public String getProperty(String propsFileName, String key) {
        return getProperties(propsFileName).getProperty(key);
    }

    public String getProperty(InputStream is, String key) {
        Map<String, String> propertyMap = getPropertiesMap(is);
        return propertyMap.get(key);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Map<String, String> getPropertiesMap(File file) {

        Properties propertiesObj = new Properties();

        try {
            propertiesObj.load(new FileInputStream(file));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        Map<String, String> map = new HashMap(propertiesObj);
        return map;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Map<String, String> getPropertiesMap(InputStream is) {

        Properties propertiesObj = new Properties();

        try {
            propertiesObj.load(is);
        } catch (IOException e) {

            throw new RuntimeException(e.getMessage(), e);
        }

        Map<String, String> map = new HashMap(propertiesObj);
        return map;
    }
}
