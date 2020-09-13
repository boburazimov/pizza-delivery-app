package uz.crm.system.repository.rest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.crm.system.entity.catalogs.Company;

@Projection(name = "customCompany", types = Company.class)
public interface CustomCompany {

    Integer getId();

    String getName();

    String getAddress();

    String getExtraInfo();
}
