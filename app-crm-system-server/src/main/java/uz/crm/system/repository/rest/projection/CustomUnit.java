package uz.crm.system.repository.rest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.crm.system.entity.catalogs.Unit;

@Projection(name = "customUnit", types = Unit.class)
public interface CustomUnit {

    Integer getId();

    String getName();
}
