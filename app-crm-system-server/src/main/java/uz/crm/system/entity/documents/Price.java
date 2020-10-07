package uz.crm.system.entity.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

/**
 * Табличная часть документа Установки цен
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Price extends AbsEntity {

    @Column(unique = true)
    private String code;

    @Column(nullable = false)
    private Date priceDate;

    @OneToMany(mappedBy = "price")
    private List<PriceRow> priceRows;

    private String extraInfo;
}
