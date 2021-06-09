package uz.crm.system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResOrder {

    private UUID id;

    private String code;

    private Date orderDate;

    private Date onTime;

    private UUID userId;

    private Boolean isPayed;

    private String userFullName;

    private UUID restaurantId;

    private String restaurantCode;

    private List<UUID> tableRows;
}
