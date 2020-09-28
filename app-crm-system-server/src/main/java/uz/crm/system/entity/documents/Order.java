package uz.crm.system.entity.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.catalogs.Payment;
import uz.crm.system.entity.catalogs.Restaurant;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.entity.enums.OrderStatusEnum;
import uz.crm.system.entity.enums.OrderTypeEnum;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order extends AbsEntity {

    @Column(unique = true)
    private String code;

    @Enumerated(value = EnumType.STRING)
    private OrderTypeEnum orderTypeEnum;

    @Enumerated(value = EnumType.STRING)
    private OrderStatusEnum orderStatusEnum;

    private Date onTime;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "order")
    private List<Payment> payments;
}
