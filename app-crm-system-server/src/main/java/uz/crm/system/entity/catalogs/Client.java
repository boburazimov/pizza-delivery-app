package uz.crm.system.entity.catalogs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.documents.BasketDoc;
import uz.crm.system.entity.enums.GenderEnum;
import uz.crm.system.entity.template.AbEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/** Клиентская база **/

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

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Address> addresses;

    private String extraInfo;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<BasketDoc> basketDocs;
}
