package uz.crm.system.entity.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.documents.SetPriceDoc;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Price {

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
