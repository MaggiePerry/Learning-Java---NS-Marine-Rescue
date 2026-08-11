package com.marinerescue.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class RescueCase {
    private final UUID id;
    private final Animal animal; // composition has-a
    private final String location;
    private final LocalDateTime reportedAt;
    private CaseStatus status;
    private final List<Observation> observations = new ArrayList<>();

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

    public void addObservation(Observation observation) {
        // Append a new observation
        observations.add(observation);
    }

    public List<Observation> getObservations() {
        // Return the list (unmodifiable)
        return Collections.unmodifiableList(observations);
    }

    @Override
    public String toString() {
        // Create string to be used for Observation foreachloop
        String obsString = "";

        for (Observation obs : observations) {
            obsString += "\n" + obs;
        }

        return ("== RescueCase ==\n ID : " + id + "\n Reported At : " + reportedAt + "\n Status : " + status
                + "\n Animal : " + animal + "\n Location : " + location + "\n Observations : " + obsString
                + "\n ================");
    }

}
