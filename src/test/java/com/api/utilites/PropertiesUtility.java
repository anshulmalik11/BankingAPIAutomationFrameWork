package com.api.utilites;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

    public static String getProperty(String filePath, String key) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Properties props = new Properties();
            props.load(fis);
            return props.getProperty(key);
        }
    }

    public static void setProperty(String filePath, String key, String value) throws IOException {
        Properties props = new Properties();
        props.setProperty(key, value);
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            props.store(fos, "Updated " + key);
        }
    }
}