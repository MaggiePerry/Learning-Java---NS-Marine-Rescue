package com.marinerescue.model;

import java.util.UUID;

public class Animal {
    private final UUID id;
    private String name;
    private Species species;
    private int age;
    private HealthStatus healthstatus;

    public Animal(String name, Species species, int age) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.species = species;
        this.age = age;
        this.healthstatus = HealthStatus.CRITICAL;
    }

    public UUID getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Species getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public HealthStatus getHealthStatus() {
        return healthstatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age Cannot be negative");
        }
        this.age = age;
    }

    public void setHealthStatus(HealthStatus healthstatus) {
        this.healthstatus = healthstatus;
    }

    @Override
    public String toString() {
        return ("Animal{id = " + id + ", name = " + name + ", species = " + species + ", age = " + age
                + ", healthstatus = " + healthstatus + "}");
    }

}
