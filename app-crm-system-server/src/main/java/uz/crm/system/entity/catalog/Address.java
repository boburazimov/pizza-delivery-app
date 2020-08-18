package uz.crm.system.entity.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable (name="client_address",
            joinColumns=@JoinColumn (name="address_id"),
            inverseJoinColumns=@JoinColumn(name="client_id"))
    private List<Client> clients;

    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    private Region region;

    @ManyToOne(fetch = FetchType.EAGER)
    private District district;

    private String StreetHome;

    private String extraAddress;

    private Long North;

    private Long West;
}
