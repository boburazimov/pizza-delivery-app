package uz.crm.system.entity.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.catalogs.Product;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Табличная часть Корзинки
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BasketTableRow extends AbsEntity {

    @ManyToOne(optional = false)
    private BasketDoc basketDoc;

    @ManyToOne(optional = false)
    private Product product;

    @Column(length = 9, nullable = false)
    private Double amount;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PriceTableRow priceTableRow;

    private Double summary;
}
