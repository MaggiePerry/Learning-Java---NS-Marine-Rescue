package com.marinerescue.repository;

import com.marinerescue.model.Animal;
import com.marinerescue.model.Species;
import java.util.*;
import java.util.stream.Collectors;

public class InMemoryAnimalRepository implements AnimalRepository {
    private final Map<UUID, Animal> storage = new HashMap<>();

    @Override
    public Animal save(Animal animal) {
        storage.put(animal.getID(), animal);
        return animal;
    }

    @Override
    public Optional<Animal> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Animal> findBySpecies(Species species) {
        // Stream API - like php array_filter
        return storage.values().stream().filter(a -> a.getSpecies() == species).collect(Collectors.toList());
    }

    @Override
    public List<Animal> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(UUID id) {
        storage.remove(id);
    }
}
