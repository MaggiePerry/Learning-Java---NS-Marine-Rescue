package com.marinerescue.model;

import java.util.UUID;

public class Volunteer {
    private final UUID id;
    private String name;
    private String phone;
    private boolean available;

    public Volunteer(String name, String phone, boolean available) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phone = phone;
        this.available = available;
    }

    // Getters
    public UUID getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean getAvailable() {
        return available;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return (name + " (" + phone + "),  Available : " + available + "");
    }
}
