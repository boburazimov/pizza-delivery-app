package uz.crm.system.entity.catalogs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.template.AbsIdEntity;

import javax.persistence.Entity;

/**
 * Головное предприятие в случаи если будут дочерные или же сетевые рестораны.
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company extends AbsIdEntity {

    private String address;

    private String extraInfo;
}
