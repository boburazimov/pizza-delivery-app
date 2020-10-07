package uz.crm.system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqAddress {

    private UUID id;

    private UUID customerId;

    private Integer districtId;

    private String StreetHome;

    private String extraAddress;

    private Double Latitude;

    private Double Longitude;
}
