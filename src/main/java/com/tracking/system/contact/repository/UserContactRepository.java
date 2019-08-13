package com.tracking.system.contact.repository;

import com.tracking.system.contact.service.model.UserContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserContactRepository extends JpaRepository<UserContact, String> {
}
