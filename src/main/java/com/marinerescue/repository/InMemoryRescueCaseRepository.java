package com.marinerescue.repository;

import com.marinerescue.model.CaseStatus;
import com.marinerescue.model.RescueCase;

import java.util.*;
import java.util.stream.Collectors;

import javax.management.AttributeList;

public class InMemoryRescueCaseRepository implements RescueCaseRepository {
    private final Map<UUID, RescueCase> storage = new HashMap<>();

    @Override
    public RescueCase save(RescueCase rescueCase) {
        storage.put(rescueCase.getID(), rescueCase);
        return rescueCase;
    }

    @Override
    public Optional<RescueCase> findById(UUID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<RescueCase> findByStatus(CaseStatus status) {
        // Stream API - like php array_filter
        return storage.values().stream().filter(rc -> rc.getStatus() == status).collect(Collectors.toList());
    }

    @Override
    public List<RescueCase> findActiveCases() {
        // Stream API - like php array_filter
        return storage.values().stream()
                .filter(rc -> rc.getStatus() != CaseStatus.RELEASED && rc.getStatus() != CaseStatus.DECEASED)
                .collect(Collectors.toList());
    }

    @Override
    public List<RescueCase> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(UUID id) {
        storage.remove(id);
    }
}
