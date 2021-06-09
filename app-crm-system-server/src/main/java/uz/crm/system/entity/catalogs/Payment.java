package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.documents.Order;
import uz.crm.system.entity.enums.PayTypeEnum;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.*;

 /**
 * Оплата от клиента, дальнейшим должно служить для оплаты через PayMe.
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment extends AbsEntity {

    @Column(unique = true)
    private String code;

    @Column(nullable = false)
    private Double sum;

    @ManyToOne(optional = false)
    private Restaurant restaurant;

    @Enumerated(EnumType.STRING)
    private PayTypeEnum payTypeEnum;

    @ManyToOne
    private User user;

    private String TerminalNumber;

    private String customerCard;

    @ManyToOne(optional = false)
    private Order order;

    private String extraInfo;
}
