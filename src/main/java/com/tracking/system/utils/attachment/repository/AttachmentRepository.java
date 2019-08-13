package com.tracking.system.utils.attachment.repository;

import com.tracking.system.utils.attachment.service.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, String>{

}
