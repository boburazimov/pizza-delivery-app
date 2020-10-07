package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.template.AbsIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Валюта (USD, UZS...)
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Currency extends AbsIdEntity {

    @Column(nullable = false, unique = true)
    private String symbolCode;
}
