package uz.crm.system.entity.catalogs;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.crm.system.entity.template.AbsIdEntity;

import javax.persistence.Entity;

/** Города Республики (Ташкент, Самарканд..) **/

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class City extends AbsIdEntity {
}
