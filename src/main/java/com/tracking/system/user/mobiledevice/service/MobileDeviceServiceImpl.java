package com.tracking.system.user.mobiledevice.service;

import com.tracking.system.user.mobiledevice.repository.MobileDeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileDeviceServiceImpl implements MobileDeviceService{
    private static final Logger LOG = LoggerFactory
            .getLogger(MobileDeviceServiceImpl.class);

    @Autowired
    private MobileDeviceRepository mobileDeviceRepository;
}
