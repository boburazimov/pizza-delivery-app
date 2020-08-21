package uz.crm.system.entity.catalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.documents.BasketDoc;
import uz.crm.system.entity.enums.GenderEnum;
import uz.crm.system.entity.template.AbEntity;
import uz.crm.system.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client extends AbEntity {

    @Column(nullable = false, length = 32)
    private String fullName;

    @Enumerated(value = EnumType.STRING)
    private GenderEnum gender;

    private Date birthDate;

    @ManyToOne
    private ClientGroup group;

    @Column(nullable = false, unique = true, length = 13)
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable (name="client_address",
            joinColumns=@JoinColumn (name="client_id"),
            inverseJoinColumns=@JoinColumn(name="address_id"))
    private List<Address> addresses;

    private String extraInfo;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<BasketDoc> basketDocs;
}
