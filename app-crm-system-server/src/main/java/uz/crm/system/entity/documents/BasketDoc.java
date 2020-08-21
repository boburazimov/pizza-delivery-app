package uz.crm.system.entity.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.catalog.Client;
import uz.crm.system.entity.catalog.Personal;
import uz.crm.system.entity.template.AbEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BasketDoc extends AbEntity {

    @Column(nullable = false)
    private String code;

    @ManyToOne(optional = false)
    private Client client;

    @ManyToOne(optional = false)
    private Personal personal;

    @OneToMany(mappedBy = "basketDoc", cascade = CascadeType.ALL)
    private List<BasketTableRow> tableRows;

    private Double totalSummary;

    private String extraInfo;
}
