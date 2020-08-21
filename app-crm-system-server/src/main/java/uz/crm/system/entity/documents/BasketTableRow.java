package uz.crm.system.entity.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.catalog.Price;
import uz.crm.system.entity.catalog.Product;
import uz.crm.system.entity.template.AbEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BasketTableRow extends AbEntity {

    @ManyToOne(optional = false)
    private BasketDoc basketDoc;

    @ManyToOne(optional = false)
    private Product product;

    @Column(length = 9, nullable = false)
    private Double count;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Price price;

    private Double summary;
}
