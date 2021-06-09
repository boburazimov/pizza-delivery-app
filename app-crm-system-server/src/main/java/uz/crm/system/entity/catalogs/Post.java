package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Должности для разграничение доступов к ресурсам (должность сотрудников ресторана).
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends AbsEntity {

    @Column(nullable = false)
    private String name;
}
