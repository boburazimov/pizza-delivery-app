package uz.crm.system.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.crm.system.entity.catalogs.CustomerGroup;
import uz.crm.system.repository.rest.projection.CustomCustomerGroup;

@CrossOrigin
@RepositoryRestResource(path = "customerGroup", collectionResourceRel = "list", excerptProjection = CustomCustomerGroup.class)
public interface CustomerGroupRepository extends JpaRepository<CustomerGroup, Integer> {
}
