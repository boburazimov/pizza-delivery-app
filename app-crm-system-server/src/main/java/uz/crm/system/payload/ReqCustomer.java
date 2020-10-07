package uz.crm.system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.enums.GenderEnum;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqCustomer {

    private UUID id;

    private String fullName;

    private GenderEnum gender;

    private Date birthDate;

    private Integer groupId;

    private String phoneNumber;

    private String extraInfo;
}
