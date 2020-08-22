package uz.crm.system.entity.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/** Внутренный персоанл ресторана (официант, заведуюший зала...) **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Personal extends AbsEntity {

    @ManyToOne(optional = false)
    private Post post;

    @Column(nullable = false, length = 4)
    private Integer pinCode;
}
