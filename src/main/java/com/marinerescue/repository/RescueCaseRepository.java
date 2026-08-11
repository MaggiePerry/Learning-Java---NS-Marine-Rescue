package com.marinerescue.repository;

import com.marinerescue.model.CaseStatus;
import com.marinerescue.model.RescueCase;

import java.util.List;

public interface RescueCaseRepository extends Repository<RescueCase> {
    List<RescueCase> findByStatus(CaseStatus status);

    List<RescueCase> findActiveCases();

}
