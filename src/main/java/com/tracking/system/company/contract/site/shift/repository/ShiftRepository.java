package com.tracking.system.company.contract.site.shift.repository;

import com.tracking.system.company.contract.site.shift.service.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, String>{
}
