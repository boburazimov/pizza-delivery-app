package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.*;

/** Для хранение адреса клиентов и доставки **/

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address extends AbsEntity {

    @ManyToOne(optional = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    private District district;

    private String StreetHome;

    private String extraAddress;

    private Long Latitude;

    private Long Longitude;
}
