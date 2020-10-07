package uz.crm.system.entity.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.catalogs.PriceType;
import uz.crm.system.entity.catalogs.Product;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Табличная часть документа установки цен для продуктов (номенклатуры)
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PriceRow extends AbsEntity {

    @ManyToOne
    private Price price;

    @ManyToOne(optional = false)
    private Product product;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PriceType priceType;

    @Column(length = 10, nullable = false)
    private Double value;
}
