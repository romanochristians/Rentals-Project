package za.co.property365.service;

import za.co.property365.domain.RentalAgent;

import java.util.List;
import java.util.Optional;

/**
 * IService.java
 * @param <T>
 * @param <ID>
 * ToDo: Method declarations for - save, read, update, delete, getAll
 */

public interface IService<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    T update(T entity);
    List<T> findAll();
    void deleteById(ID id);

}