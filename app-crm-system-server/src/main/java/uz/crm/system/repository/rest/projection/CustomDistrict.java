package uz.crm.system.repository.rest.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import uz.crm.system.entity.catalogs.District;
import uz.crm.system.entity.catalogs.Region;

@Projection(name = "customDistrict", types = District.class)
public interface CustomDistrict {

    Integer getId();

    String getName();

    @Value("#{target.region?.id?:null}")
    Region getRegionId();
}
