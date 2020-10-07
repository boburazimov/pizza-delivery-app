package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.documents.Cart;
import uz.crm.system.entity.documents.Order;
import uz.crm.system.entity.enums.GenderEnum;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Клиентская база
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends AbsEntity {

    @Column(length = 32)
    private String fullName;

    @Enumerated(value = EnumType.STRING)
    private GenderEnum gender;

    private Date birthDate;

    @ManyToOne
    private CustomerGroup group;

    @Column(nullable = false, unique = true, length = 13)
    private String phoneNumber;

    private String extraInfo;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Cart> carts;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
