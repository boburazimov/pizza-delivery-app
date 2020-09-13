package uz.crm.system.repository.rest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.crm.system.entity.catalogs.Currency;

@Projection(name = "customCurrency", types = Currency.class)
public interface CustomCurrency {

    Integer getId();

    String getMainName();

    String getSymbolCode();
}
