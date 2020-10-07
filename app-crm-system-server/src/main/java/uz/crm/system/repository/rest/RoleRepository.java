package uz.crm.system.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.crm.system.entity.catalogs.Role;
import uz.crm.system.entity.enums.RoleNameEnum;
import uz.crm.system.repository.rest.projection.CustomRole;

@RepositoryRestResource(path = "role", collectionResourceRel = "list", excerptProjection = CustomRole.class)
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(RoleNameEnum name);
}
