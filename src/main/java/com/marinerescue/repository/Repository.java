package com.marinerescue.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Repository<T> {
    T save(T enitiy);

    Optional<T> findById(UUID id);

    List<T> findByAll();

    void delete(UUID id);

}
