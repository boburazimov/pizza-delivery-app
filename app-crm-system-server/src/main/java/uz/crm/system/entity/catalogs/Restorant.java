package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restorant extends AbsEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private Company company;

    private String adress;

    @ManyToOne(optional = false)
    private Currency currency;
}
