package uz.crm.system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResAddress {

    private UUID id;

    private UUID clientId;

    private Integer districtId;

    private String StreetHome;

    private String extraAddress;

    private Long North;

    private Long West;
}
