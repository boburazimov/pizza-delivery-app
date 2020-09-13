package uz.crm.system.repository.rest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.crm.system.entity.catalogs.PayMethod;

@Projection(name = "customPayMethod", types = PayMethod.class)
public interface CustomPayMethod {

    Integer getId();

    String getName();
}
