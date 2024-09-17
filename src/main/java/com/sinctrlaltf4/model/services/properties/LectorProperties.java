package com.sinctrlaltf4.model.services.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LectorProperties {
    private static final String ARCHIVO_PROPERTIES = "src\\main\\resources\\application.properties";
    private Properties properties;

    public LectorProperties() throws IOException {
        this.properties = new Properties();
        properties.load(new FileReader(ARCHIVO_PROPERTIES));
    }

    public String leerPropiedad(String key) {
        return this.properties.getProperty(key);
    }
}
