package com.tracking.system.company.contract.site.shift.shiftevent.service;

import com.tracking.system.company.contract.site.shift.repository.ShiftRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiftEventServiceImpl implements ShiftEventService {
    private static final Logger LOG = LoggerFactory
            .getLogger(ShiftEventServiceImpl.class);

    @Autowired
    private ShiftRepository shiftRepository;
}
