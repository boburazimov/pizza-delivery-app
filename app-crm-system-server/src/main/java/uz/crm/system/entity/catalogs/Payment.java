package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.documents.OrderDoc;
import uz.crm.system.entity.enums.PayTypeEnum;
import uz.crm.system.entity.template.AbEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment extends AbEntity {

    @Column(unique = true)
    private String code;

    @Column(nullable = false)
    private Timestamp payDate;

    private String ownerCard;

    @Column(nullable = false)
    private Double paySum;

    @ManyToOne(optional = false)
    private Restaurant restaurant;

    @Enumerated(EnumType.STRING)
    private PayTypeEnum payTypeEnum;

    @ManyToOne
    private User user;

    @ManyToOne(optional = false)
    private Client client;

    private String clientCard;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrderDoc orderDoc;

    private String extraInfo;
}
