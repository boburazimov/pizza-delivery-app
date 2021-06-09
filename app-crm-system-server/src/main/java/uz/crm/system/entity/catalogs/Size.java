package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.template.AbsIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Размер блюдо: Пицца
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Size extends AbsIdEntity {

    @Column(nullable = false, length = 3)
    private Double value;
}
