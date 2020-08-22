package uz.crm.system.entity.catalog;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.crm.system.entity.template.AbsIdEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/** Группировка клиентов на разные типы по мнению компании **/

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ClientGroup extends AbsIdEntity {

    @ManyToOne
    private ClientGroup parent;
}
