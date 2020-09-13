package uz.crm.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.crm.system.entity.catalogs.Client;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

}
