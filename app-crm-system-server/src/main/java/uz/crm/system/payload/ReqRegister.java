package uz.crm.system.payload;

import lombok.Data;
import uz.crm.system.entity.catalogs.Post;
import uz.crm.system.entity.catalogs.Restaurant;

import java.util.UUID;

@Data
public class ReqRegister {

    private String firstName;

    private String lastName;

    private UUID restaurantId;

    private String phoneNumber;

    private UUID postId;

    private String password;

    private String prePassword;

    private Integer pinCode;
}
