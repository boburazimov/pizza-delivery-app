package uz.crm.system.repository.rest.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import uz.crm.system.entity.catalogs.CustomerGroup;

@Projection(name = "customCustomerGroup", types = CustomerGroup.class)
public interface CustomCustomerGroup {

    Integer getId();

    String getName();

    @Value("#{target.parent?.id?: null}")
    Integer getParentId();
}
