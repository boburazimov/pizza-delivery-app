package uz.crm.system.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.crm.system.entity.catalogs.Restaurant;
import uz.crm.system.repository.rest.projection.CustomRestaurant;

import java.util.UUID;

@CrossOrigin
@RepositoryRestResource(path = "restaurant", collectionResourceRel = "list", excerptProjection = CustomRestaurant.class)
public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {
}
