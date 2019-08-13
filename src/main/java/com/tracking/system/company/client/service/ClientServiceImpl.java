package com.tracking.system.company.client.service;

import com.tracking.system.company.client.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private static final Logger LOG = LoggerFactory
            .getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepository clientRepository;
}
