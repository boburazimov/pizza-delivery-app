package uz.crm.system.repository.rest.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import uz.crm.system.entity.catalogs.City;
import uz.crm.system.entity.catalogs.Region;

@Projection(name = "customRegion", types = Region.class)
public interface CustomRegion {

    Integer getId();

    String getName();

    @Value("#{target.city?.id?:null}")
    City getCityId();
}
