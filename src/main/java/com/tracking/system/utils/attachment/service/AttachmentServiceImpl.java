package com.tracking.system.utils.attachment.service;

import com.tracking.system.utils.attachment.repository.AttachmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    private static final Logger LOG = LoggerFactory
            .getLogger(AttachmentServiceImpl.class);

    @Autowired
    private AttachmentRepository attachmentRepository;
}
