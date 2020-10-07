package uz.crm.system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqRegister {

    private UUID id;

    private String fullName;

    private UUID restaurantId;

    private String phoneNumber;

    private UUID postId;

    //    @Pattern (regexp = "[a-zA-Z0-9]{6,30}", message = "Длина пароля не должен быть меньше 6 знаков!")
    private String password;

    private String prePassword;

    private Integer pinCode;
}
