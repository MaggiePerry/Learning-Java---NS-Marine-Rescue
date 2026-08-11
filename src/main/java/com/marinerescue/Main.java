package com.marinerescue;

import java.util.UUID;

import com.marinerescue.model.*;
import com.marinerescue.repository.InMemoryAnimalRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("Marine Rescue System Starting...");

        // Define Animal Repo
        InMemoryAnimalRepository repo = new InMemoryAnimalRepository();

        // Enter new animal
        Animal baby = new Animal("Baby", Species.HARBOUR_SEAL, 2);
        System.out.println(baby);

        // Save to mem
        repo.save(baby);

        // Find by ID
        System.out.println(repo.findById(baby.getID()));
        // Random ID test
        System.out.println(repo.findById(UUID.randomUUID()));

        // Find by species
        System.out.println(repo.findBySpecies(Species.HARBOUR_SEAL));

        // Find by all
        System.out.println(repo.findByAll());

        // Delete
        repo.delete(baby.getID());
        System.out.println(repo.findByAll()); // should be empty

        // RescueCase case_one = new RescueCase(baby, "Halifax");

        // case_one.addObservation(new Observation("Poor baby got injured by a boat
        // propeller", "Maggie"));

        // System.out.println(case_one);

        // Assigning
        // case_one.assignVolunteer(new Volunteer("Maggie", "902-880-1234", true));
        // System.out.println(case_one);

        // In rescue
        // case_one.advanceStatus();
        // System.out.println(case_one);

        // Rehabilitating
        // case_one.advanceStatus();
        // case_one.addObservation(
        // new Observation("Baby is recovering well and should be ready to release
        // soon", "Maggie"));

        // System.out.println(case_one);

        // Update health status
        // baby.setHealthStatus(HealthStatus.STABLE);
        // System.out.println(baby);

        // Released
        // case_one.advanceStatus();
        // case_one.addObservation(
        // new Observation("Baby is released!", "Maggie"));

        // System.out.println(case_one);

        // Case two animal testing without adding volunteer or observations
        // Animal fuzzy = new Animal("Fuzzy", Species.PUFFIN, 1);
        // System.out.println(fuzzy);

        // RescueCase case_two = new RescueCase(fuzzy, "Cape Breton");
        // case_two.advanceStatus();
        // System.out.println(case_two);
        // case_two.advanceStatus();
        // System.out.println(case_two);
        // case_two.advanceStatus();
        // System.out.println(case_two);
        // case_two.advanceStatus();
        // System.out.println(case_two);

        // Try to set age to invalid value
        // baby.setAge(-1);
        // System.out.println(baby);

        // Case is closed throw error when trying to advance
        // case_one.advanceStatus();

        // Testing adding a observation incorrectly does not work
        // case_one.getObservations().add(new Observation("Trying to add an observation
        // incorrectly","Bad"));

    }
}
