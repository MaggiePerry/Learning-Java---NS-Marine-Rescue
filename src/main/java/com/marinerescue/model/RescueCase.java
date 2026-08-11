package com.marinerescue.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class RescueCase {
    private final UUID id;
    private final Animal animal; // composition has-a
    private final String location;
    private final LocalDateTime reportedAt;
    private CaseStatus status;

    public RescueCase(Animal animal, String location) {
        this.id = UUID.randomUUID();
        this.reportedAt = LocalDateTime.now();
        this.status = CaseStatus.REPORTED;
        this.animal = animal;
        this.location = location;
    }

    public void advanceStatus() {

        // If the case is closed (animal is released or deceased) throw error
        if (this.status == CaseStatus.RELEASED || this.status == CaseStatus.DECEASED) {
            throw new IllegalArgumentException("Case is closed");
        }

        // Get all possible Statuses
        // CaseStatus.values();

        // Find current status position
        // this.status.ordinal();

        // Advance case status to next state
        this.status = CaseStatus.values()[this.status.ordinal() + 1];

    }

    @Override
    public String toString() {
        return ("RescueCase{id = " + id + ", repostedAt = " + reportedAt + ", status = " + status + ", animal = "
                + animal + ", location = " + location + "}");
    }

}
