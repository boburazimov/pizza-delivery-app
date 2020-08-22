package uz.crm.system.entity.catalog;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.crm.system.entity.template.AbsIdEntity;

import javax.persistence.Entity;

/** Единица измерение товаров (шт, кг...) **/

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Unit extends AbsIdEntity {
}
