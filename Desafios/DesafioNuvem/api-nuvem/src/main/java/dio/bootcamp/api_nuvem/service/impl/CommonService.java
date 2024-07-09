package dio.bootcamp.api_nuvem.service.impl;

import java.util.List;
import java.util.Optional;

import dio.bootcamp.api_nuvem.model.AtividadesCursos;
import dio.bootcamp.api_nuvem.model.Bootcamp;

public interface CommonService<T> {
    List<T> findAll();
    long count();

    default Bootcamp findById(String id) {
        throw new UnsupportedOperationException();
    }

    default T save(T entity) {
        throw new UnsupportedOperationException();
    }
    
    default AtividadesCursos findById(Long id) {
        throw new UnsupportedOperationException();
    }

    default boolean deleteById(String id) {
        throw new UnsupportedOperationException();
    }

    default boolean deleteById(Long id) {
        throw new UnsupportedOperationException();
    }

    default Optional<T> findByName(String name) {
        throw new UnsupportedOperationException();
    }

    default Optional<T> findByTitle(String title) {
        throw new UnsupportedOperationException();
    }
}
