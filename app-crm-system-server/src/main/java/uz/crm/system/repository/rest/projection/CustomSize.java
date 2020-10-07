package uz.crm.system.repository.rest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.crm.system.entity.catalogs.Size;

@Projection(name = "customSize", types = Size.class)
public interface CustomSize {

    Integer getId();

    String getName();

    Double getValue();
}
