package uz.crm.system.repository.rest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.crm.system.entity.catalogs.PriceType;

@Projection(name = "customPriceType", types = PriceType.class)
public interface CustomPriceType {

    Integer getId();

    String getName();
}
