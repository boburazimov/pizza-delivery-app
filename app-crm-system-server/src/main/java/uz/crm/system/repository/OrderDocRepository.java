package uz.crm.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.crm.system.entity.documents.OrderDoc;

import java.util.List;
import java.util.UUID;

public interface OrderDocRepository extends JpaRepository<OrderDoc, UUID> {

    List<OrderDoc> findAllByRestaurantId(UUID restaurant_id);

    List<OrderDoc> findAllByUserId(UUID user_id);
}
