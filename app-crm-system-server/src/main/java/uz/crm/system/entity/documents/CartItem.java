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
 * Табличная часть Корзинки - каждый товар будет хранится отдельно в этой таблице
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItem extends AbsEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @ManyToOne(optional = false)
    private Product product;

    @Column(length = 9, nullable = false)
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private PriceRow priceRow;

    private Double summary;
}
