package uz.crm.system.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import uz.crm.system.entity.catalogs.Company;
import uz.crm.system.repository.rest.projection.CustomCompany;

import java.util.UUID;

@CrossOrigin
@RepositoryRestResource(path = "company", collectionResourceRel = "list", excerptProjection = CustomCompany.class)
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
