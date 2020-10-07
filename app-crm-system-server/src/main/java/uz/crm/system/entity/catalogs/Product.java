package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.documents.PriceRow;
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

    @ManyToOne
    private Category category;

    private Boolean top;

    private String barcode;

    private String article;

    @OneToOne
    private Attachment photo;

    @ManyToOne
    private Unit unit;

    @ManyToMany
    @JoinTable(
            name="product_size",
            joinColumns=@JoinColumn(name="product_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="size_id", referencedColumnName="id"))
    private List<Size> sizes;

    @OneToMany(mappedBy = "product")
    private List<PriceRow> priceRows;
}
