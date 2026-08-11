package com.marinerescue.model;

import java.time.LocalDateTime;

public class Observation {
    private final LocalDateTime timestamp;
    private final String notes;
    private final String observerName;

    public Observation(String notes, String observerName) {
        this.timestamp = LocalDateTime.now();
        this.notes = notes;
        this.observerName = observerName;
    }

    @Override
    public String toString() {
        return (" - [" + timestamp + "] " + observerName + " : " + notes);
    }

}
