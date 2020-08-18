package uz.crm.system.entity.catalog;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.crm.system.entity.template.AbsIdEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Category extends AbsIdEntity {

    @ManyToOne
    private Category parent;
}
