package uz.crm.system.entity.catalogs;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.crm.system.entity.template.AbsIdEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Группировка клиентов на разные типы по мнению компании
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class CustomerGroup extends AbsIdEntity {

    @ManyToOne
    private CustomerGroup parent;
}
