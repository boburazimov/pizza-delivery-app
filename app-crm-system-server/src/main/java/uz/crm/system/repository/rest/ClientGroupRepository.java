package uz.crm.system.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.crm.system.entity.catalogs.ClientGroup;
import uz.crm.system.repository.rest.projection.CustomClientGroup;

@CrossOrigin
@RepositoryRestResource(path = "clientGroup", collectionResourceRel = "list", excerptProjection = CustomClientGroup.class)
public interface ClientGroupRepository extends JpaRepository<ClientGroup, Integer> {
}
