package uz.crm.system.entity.template;

import lombok.Data;

import javax.persistence.*;

/**
 * Не сущность - шаблон для сущностей с одинаковыми свойствами (сложный вариант - AbsEntity).
 **/

@Data
@MappedSuperclass
public abstract class AbsIdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
}
