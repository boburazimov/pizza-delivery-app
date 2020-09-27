package uz.crm.system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.enums.PayTypeEnum;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqPayment {

    private UUID id;

    private String code;

    private Double sum;

    private UUID restaurantId;

    private PayTypeEnum payTypeEnum;

    private String TerminalNumber;

    private String clientCard;

    private UUID orderDocId;

    private String extraInfo;
}
