package uz.crm.system.entity.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.catalog.PriceType;
import uz.crm.system.entity.catalog.Product;
import uz.crm.system.entity.documents.SetPriceDoc;

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
