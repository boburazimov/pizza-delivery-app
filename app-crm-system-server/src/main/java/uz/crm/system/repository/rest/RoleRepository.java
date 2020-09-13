package uz.crm.system.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.crm.system.entity.catalogs.Role;
import uz.crm.system.entity.enums.RoleNameEnum;

@RepositoryRestResource(path = "role", collectionResourceRel = "list")
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(RoleNameEnum name);
}
