package uz.crm.system.entity.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.template.AbsEntity;
import uz.crm.system.entity.template.Attachment;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbsEntity {

    @ManyToOne
    private Category category;

    private String barcode;

    private String article;

    @OneToOne
    private Attachment photo;

    @ManyToOne
    private Unit unit;

    @OneToMany(mappedBy = "product")
    private List<Price> prices;


}
