package com.tracking.system.company.contract.site.shift.service;

import com.tracking.system.company.contract.site.shift.repository.ShiftRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiftServiceImpl implements ShiftService{
    private static final Logger LOG = LoggerFactory
            .getLogger(ShiftServiceImpl.class);

    @Autowired
    private ShiftRepository shiftRepository;
}
