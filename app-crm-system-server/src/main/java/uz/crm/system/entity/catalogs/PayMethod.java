package uz.crm.system.entity.catalogs;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.crm.system.entity.template.AbsIdEntity;

import javax.persistence.Entity;

/**
 * Для методов оплаты по безналичнаму расчету (PeyMe, PayPall, Click...)
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PayMethod extends AbsIdEntity {
}
