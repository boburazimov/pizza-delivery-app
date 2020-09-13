package uz.crm.system.repository.rest.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import uz.crm.system.entity.catalogs.Company;
import uz.crm.system.entity.catalogs.Currency;
import uz.crm.system.entity.catalogs.Restaurant;

import java.util.UUID;

@Projection(name = "customRestaurant", types = Restaurant.class)
public interface CustomRestaurant {

    UUID getId();

    String getInterCode();

    String getName();

    Company getCompany();

    @Value("#{target.company?.id?:null}")
    Integer getCompanyId();

    String getAddress();

    Currency getCurrency();

    @Value("#{target.currency?.id?:null}")
    Integer getCurrencyId();

    String getExtraInfo();
}
