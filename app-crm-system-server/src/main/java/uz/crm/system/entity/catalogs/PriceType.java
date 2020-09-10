package uz.crm.system.entity.catalogs;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.crm.system.entity.template.AbsIdEntity;

import javax.persistence.Entity;

/** Виды цен (Оптовая, Розницная...) **/

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PriceType extends AbsIdEntity {
}
