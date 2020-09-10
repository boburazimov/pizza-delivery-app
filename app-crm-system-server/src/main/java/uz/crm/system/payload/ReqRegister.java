package uz.crm.system.payload;

import lombok.Data;
import uz.crm.system.entity.catalogs.Post;
import uz.crm.system.entity.catalogs.Restorant;

@Data
public class ReqRegister {

    private String firstName;

    private String lastName;

    private Restorant restorant;

    private String phoneNumber;

    private Post post;

    private String password;

    private String prePassword;

    private Integer pinCode;
}
