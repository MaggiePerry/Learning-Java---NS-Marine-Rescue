package com.marinerescue;

import com.marinerescue.model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Marine Rescue System Starting...");

        // Enter new animal
        Animal baby = new Animal("Baby", Species.HARBOUR_SEAL, 2);
        System.out.println(baby);

        // Update health status
        baby.setHealthStatus(HealthStatus.STABLE);
        System.out.println(baby);

        // Try to set age to invalid value
        // baby.setAge(-1);
        // System.out.println(baby);
    }
}
