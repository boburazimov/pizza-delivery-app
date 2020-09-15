package uz.crm.system.entity.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.catalogs.Client;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Корзина для клиентов (в телеграме)
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BasketDoc extends AbsEntity {

    @Column(nullable = false)
    private String code;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;

    @OneToMany(mappedBy = "basketDoc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BasketTableRow> tableRows;

    private Double totalSummary;

    private String extraInfo;
}
