package uz.crm.system.repository.rest.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import uz.crm.system.entity.catalogs.ClientGroup;

@Projection(name = "customClientGroup", types = ClientGroup.class)
public interface CustomClientGroup {

    Integer getId();

    String getName();

    @Value("#{target.parent?.id?: null}")
    Integer getParentId();
}
