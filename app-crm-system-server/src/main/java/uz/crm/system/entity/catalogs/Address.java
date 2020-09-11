package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/** Для хранение адреса клиентов и доставки **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    private District district;

    private String StreetHome;

    private String extraAddress;

    private Long North;

    private Long West;
}