package com.tracking.system.company.contract.site.shift.shiftevent.repository;

import com.tracking.system.company.contract.site.shift.shiftevent.service.model.ShiftEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftEventRepository extends JpaRepository<ShiftEvent, String>{
}
