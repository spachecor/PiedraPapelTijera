package com.sinctrlaltf4.model.services.repository;

import com.sinctrlaltf4.model.entity.Entidad;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

/**
 * Clase que define los métodos con los que se realizará el CRUD con la base de datos. Paso final para acceder.
 * Hace uso del repositorio para el acceso.
 * @param <T> entidad que herede de Entidad
 * @see GenericRepositoryImpl
 * @author SinCtrlAltF4
 * @version 1.0
 */
public class GenericRepositoryServiceImpl<T extends Entidad> implements CRUDRepositoryService<T> {
    private EntityManager em;
    private CRUDRepository<T> repository;

    public GenericRepositoryServiceImpl(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.repository = new GenericRepositoryImpl<>(em, entityClass);
    }

    @Override
    public List<T> listar() {
        return repository.listar();
    }

    @Override
    public Optional<T> porId(Integer id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(T t) {
        try{
            em.getTransaction().begin();
            repository.guardar(t);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            //TODO agregar logger
        }
    }

    @Override
    public void eliminar(Integer id) {
        try{
            em.getTransaction().begin();
            repository.eliminar(id);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            //TODO agregar logger
        }
    }
}

