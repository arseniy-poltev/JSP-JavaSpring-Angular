package com.tracking.system.contact.service;

import com.tracking.system.contact.repository.UserContactRepository;
import com.tracking.system.contact.service.model.UserContact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserContactServiceImpl implements UserContactService {
    private static final Logger LOG = LoggerFactory
            .getLogger(UserContactServiceImpl.class);

    @Autowired
    private UserContactRepository contactRepository;

    @Override
    public UserContact save(UserContact contact) {
        return contactRepository.save(contact);
    }
}
