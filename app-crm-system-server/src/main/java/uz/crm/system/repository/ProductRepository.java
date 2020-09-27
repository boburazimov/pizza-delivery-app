package uz.crm.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.crm.system.entity.catalogs.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findAllByCategoryId(Integer category_id);
}
