package uz.crm.system.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.crm.system.entity.catalogs.PriceType;
import uz.crm.system.repository.rest.projection.CustomPriceType;

@CrossOrigin
@RepositoryRestResource(path = "priceType", collectionResourceRel = "list", excerptProjection = CustomPriceType.class)
public interface PriceTypeRepository extends JpaRepository<PriceType, Integer> {
}
