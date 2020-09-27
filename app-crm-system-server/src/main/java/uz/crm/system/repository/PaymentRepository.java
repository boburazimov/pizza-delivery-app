package uz.crm.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.crm.system.entity.catalogs.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    List<Payment> findAllByRestaurantId(UUID restaurant_id);

    @Query(value = "select code from payment order by code desc limit 1", nativeQuery = true)
    String getMaxCode();
}
