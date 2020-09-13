package uz.crm.system.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.crm.system.entity.catalogs.PayMethod;
import uz.crm.system.repository.rest.projection.CustomPayMethod;

@CrossOrigin
@RepositoryRestResource(path = "payMethod", collectionResourceRel = "list", excerptProjection = CustomPayMethod.class)
public interface PayMethodRepository extends JpaRepository<PayMethod, Integer> {
}
