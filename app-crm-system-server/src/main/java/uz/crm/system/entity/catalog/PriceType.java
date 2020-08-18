package uz.crm.system.entity.catalog;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.crm.system.entity.template.AbsIdEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PriceType extends AbsIdEntity {
}
