package com.tracking.system.company.employee.trackinposition.service;

import com.tracking.system.company.employee.trackinposition.repository.TrackingPositionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackingPositionServiceImpl implements TrackingPositionService{
    private static final Logger LOG = LoggerFactory
            .getLogger(TrackingPositionServiceImpl.class);

    @Autowired
    private TrackingPositionRepository trackingPositionRepository;
}
