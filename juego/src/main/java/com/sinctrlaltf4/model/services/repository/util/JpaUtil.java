package com.sinctrlaltf4.model.services.repository.util;

import com.sinctrlaltf4.model.services.properties.LectorProperties;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que se encarga de gestionar la persistencia en la base de datos.
 * @author SinCtrlAltF4
 * @version 1.0
 */
public class JpaUtil {
    private static final EntityManagerFactory EMF;
    static{
        try {
            EMF = buildEntityManagerFactory();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que crea un EntityManagerFactory para toda la appp a partir de la unidad de persistencia
     * @return El EntityManagerFactory de la app
     */
    private static EntityManagerFactory buildEntityManagerFactory() throws IOException {
        LectorProperties lectorProperties = new LectorProperties();
        JpaUtil.crearBaseDeDatos(lectorProperties.leerPropiedad("url"), lectorProperties.leerPropiedad("user")
                , lectorProperties.leerPropiedad("password"), lectorProperties.leerPropiedad("dbName"));
        return Persistence.createEntityManagerFactory("Juego");
    }

    /**
     * Método que crea una base de datos si esta no existe
     * @param url La url de la base de datos
     * @param user El usuario para acceder a la conexión
     * @param password La constraseña para acceder a la conexión
     * @param dbName El nombre de la base de datos
     */
    private static void crearBaseDeDatos(String url, String user, String password, String dbName){
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que crea un EntityManager por cada conexión a partir del ENTITY_MANAGER_FACTORY
     * @return El EntityManager de cada conexión
     */
    public static EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }
}
