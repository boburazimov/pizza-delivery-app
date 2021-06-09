package uz.crm.system.entity.catalogs;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.crm.system.entity.template.AbsIdEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Группировка клиентов на разные типы: Лояльные, Черный список и т.д.
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class CustomerGroup extends AbsIdEntity {

    @ManyToOne
    private CustomerGroup parent;
}
