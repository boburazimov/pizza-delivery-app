package uz.crm.system.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.crm.system.entity.catalogs.Unit;
import uz.crm.system.repository.rest.projection.CustomUnit;

@CrossOrigin
@RepositoryRestResource(path = "unit", collectionResourceRel = "list", excerptProjection = CustomUnit.class)
public interface UnitRepository extends JpaRepository<Unit, Integer> {
}
