package com.tracking.system.user.mobiledevice.repository;

import com.tracking.system.user.mobiledevice.service.model.MobileDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileDeviceRepository extends JpaRepository<MobileDevice, String> {
}
