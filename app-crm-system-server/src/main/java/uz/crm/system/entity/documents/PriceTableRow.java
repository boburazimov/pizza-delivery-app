package uz.crm.system.entity.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.catalogs.PriceType;
import uz.crm.system.entity.catalogs.Product;

import javax.persistence.*;

/** Табличная часть документа установки цен для продуктов (номенклатуры) **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PriceTableRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private SetPriceDoc priceDoc;

    @ManyToOne(optional = false)
    private Product product;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PriceType priceType;

    @Column(length = 10, nullable = false)
    private Double value;
}
