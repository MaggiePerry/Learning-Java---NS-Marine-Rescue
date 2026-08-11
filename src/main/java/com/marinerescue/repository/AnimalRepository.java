package com.marinerescue.repository;

import com.marinerescue.model.Animal;
import com.marinerescue.model.Species;
import java.util.List;

public interface AnimalRepository extends Repository<Animal> {
    List<Animal> findBySpecies(Species species);
}
