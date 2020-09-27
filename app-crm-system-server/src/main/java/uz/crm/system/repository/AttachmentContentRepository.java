package uz.crm.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.crm.system.entity.catalogs.Attachment;
import uz.crm.system.entity.catalogs.AttachmentContent;

import java.util.UUID;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {

    AttachmentContent findByAttachmentId(UUID attachment_id);

    void deleteByAttachmentId(UUID attachment_id);

    void deleteByAttachment(Attachment attachment);
}
