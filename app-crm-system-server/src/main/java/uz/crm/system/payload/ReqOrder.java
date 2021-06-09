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
public class ReqOrder {

    private UUID id;

    private String code;

    private Date orderDate;

    private Date onTime;

    private Boolean isPayed;

    private UUID restaurantId;

    private List<UUID> tableRows;
}
