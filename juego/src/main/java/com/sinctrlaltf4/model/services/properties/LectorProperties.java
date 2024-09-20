package com.sinctrlaltf4.model.services.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Clase que se encarga de gestionar la lectura de propiedades del application.properties
 * @author SinCtrlAltF4
 * @version 1.0
 */
public class LectorProperties {
    private static final String ARCHIVO_PROPERTIES = "src\\main\\resources\\application.properties";
    private Properties properties;

    public LectorProperties() throws IOException {
        this.properties = new Properties();
        properties.load(new FileReader(ARCHIVO_PROPERTIES));
    }
    /**
     * Método que se encarga de leer la propiedad que coincida con la key que entre
     * @param key La cadena que defina la propiedad que queremos leer
     * @return La propiedad en concreto en forma de cadena
     */
    public String leerPropiedad(String key) {
        return this.properties.getProperty(key);
    }
}
