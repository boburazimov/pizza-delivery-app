package uz.crm.system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqRegister {

    private String fullName;

    private UUID restaurantId;

    private String phoneNumber;

    private UUID postId;

    private String password;

    private String prePassword;

    private Integer pinCode;
}
