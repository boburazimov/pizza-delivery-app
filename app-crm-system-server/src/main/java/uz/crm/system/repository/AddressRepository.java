package uz.crm.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.crm.system.entity.catalogs.Address;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
