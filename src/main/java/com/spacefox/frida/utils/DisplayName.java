package com.spacefox.frida.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class DisplayName {
    private static DisplayName ourInstance;

    static {
        try {
            ourInstance = new DisplayName();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static DisplayName getInstance() {
        return ourInstance;
    }

    private static PropertiesConfiguration resource;

    private DisplayName() throws ConfigurationException {
        resource = new PropertiesConfiguration("locale_ru.properties");
    }

    public static String get(String key){
        return resource.getString(key);
    }
}
