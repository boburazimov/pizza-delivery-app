package uz.crm.system.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.crm.system.entity.catalogs.City;
import uz.crm.system.repository.rest.projection.CustomCity;

@CrossOrigin
@RepositoryRestResource(path = "city", collectionResourceRel = "list", excerptProjection = CustomCity.class)
public interface CityRepository extends JpaRepository<City, Integer> {
}
