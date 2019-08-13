package com.tracking.system.company.employee.trackinposition.repository;

import com.tracking.system.company.employee.trackinposition.service.model.TrackingPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingPositionRepository extends JpaRepository<TrackingPosition, String> {
}
