package com.marinerescue.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RescueCase {
    private final UUID id;
    private final Animal animal; // composition has-a
    private final String location;
    private final LocalDateTime reportedAt;
    private CaseStatus status;
    private final List<Observation> observations = new ArrayList<>();
    private Volunteer assignedVolunteer;

    public RescueCase(Animal animal, String location) {
        this.id = UUID.randomUUID();
        this.reportedAt = LocalDateTime.now();
        this.status = CaseStatus.REPORTED;
        this.animal = animal;
        this.location = location;
    }

    // Getters
    public UUID getID() {
        return id;
    }

    public CaseStatus getStatus() {
        return status;
    }

    // Advances the rescue status of a resuce case
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

    // Append a new observation
    public void addObservation(Observation observation) {
        observations.add(observation);
    }

    // Return the list (unmodifiable)
    public List<Observation> getObservations() {
        return Collections.unmodifiableList(observations);
    }

    // Get assigned Volunteer if present (can be null)
    public Optional<Volunteer> getAssignedVolunteer() {
        return Optional.ofNullable(assignedVolunteer);
    }

    public void assignVolunteer(Volunteer volunteer) {
        // IF the case is reported AND the volunteer is available, assign the volunteer
        if (this.status == CaseStatus.REPORTED && volunteer.getAvailable() == true) {
            this.assignedVolunteer = volunteer;
            this.status = CaseStatus.ASSIGNED;
        }
    }

    @Override
    public String toString() {
        // Create string to be used for Observation foreachloop
        String obsString = "";

        for (Observation obs : observations) {
            obsString += "\n" + obs;
        }

        return ("== RescueCase ==\n ID : " + id + "\n Reported At : " + reportedAt + "\n Status : " + status
                + "\n Animal : " + animal + "\n Volunteer : " + assignedVolunteer + "\n Observations : " + obsString
                + "\n ================");
    }

}
