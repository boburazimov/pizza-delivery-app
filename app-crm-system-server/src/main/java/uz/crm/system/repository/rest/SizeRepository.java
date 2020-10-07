package uz.crm.system.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.crm.system.entity.catalogs.Size;
import uz.crm.system.repository.rest.projection.CustomSize;

@CrossOrigin
@RepositoryRestResource(path = "size", collectionResourceRel = "list", excerptProjection = CustomSize.class)
public interface SizeRepository extends JpaRepository<Size, Integer> {

}
