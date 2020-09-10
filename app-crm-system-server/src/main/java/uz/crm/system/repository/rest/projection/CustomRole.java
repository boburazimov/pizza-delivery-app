package uz.crm.system.repository.rest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.crm.system.entity.catalogs.Role;
import uz.crm.system.entity.enums.RoleNameEnum;

@Projection(name = "/customRole", types = Role.class)
public interface CustomRole {

    Integer getId();

    RoleNameEnum getName();
}
