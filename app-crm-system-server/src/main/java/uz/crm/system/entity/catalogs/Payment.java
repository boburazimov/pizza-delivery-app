package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.documents.OrderDoc;
import uz.crm.system.entity.enums.PayTypeEnum;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.*;
import java.sql.Timestamp;

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

    private String clientCard;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrderDoc orderDoc;

    private String extraInfo;
}
