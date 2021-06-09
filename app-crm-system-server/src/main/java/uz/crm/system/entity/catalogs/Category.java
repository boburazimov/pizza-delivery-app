package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.template.AbsIdEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Категория для товаров: молочка, сухофрукты, зелень и т.д.
 * topCategory - является ли товар в топе.
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends AbsIdEntity {

    @ManyToOne
    private Category parent;

    private Boolean topCategory;
}
