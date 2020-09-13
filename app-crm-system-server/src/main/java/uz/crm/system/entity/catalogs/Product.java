package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.documents.PriceTableRow;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbsEntity {

    @Column(nullable = false)
    private String name;

    private Double size;

    @ManyToOne
    private Category category;

    private String barcode;

    private String article;

    @OneToOne
    private Attachment photo;

    @ManyToOne
    private Unit unit;

    @OneToMany(mappedBy = "product")
    private List<PriceTableRow> priceTableRows;


}
