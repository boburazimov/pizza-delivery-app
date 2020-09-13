package uz.crm.system.repository.rest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.crm.system.entity.catalogs.City;

@Projection(name = "customCity", types = City.class)
public interface CustomCity {

    Integer getId();

    String getName();
}
