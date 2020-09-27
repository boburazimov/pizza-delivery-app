package uz.crm.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.crm.system.entity.catalogs.Attachment;

import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
}
