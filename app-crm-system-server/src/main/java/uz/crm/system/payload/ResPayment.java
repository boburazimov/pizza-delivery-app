package uz.crm.system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.crm.system.entity.catalogs.Restaurant;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.entity.documents.OrderDoc;
import uz.crm.system.entity.enums.PayTypeEnum;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResPayment {

    private UUID id;

    private String code;

    private Double sum;

    private UUID restaurantId;

    private String restaurantCode;

    private PayTypeEnum payTypeEnum;

    private UUID userId;

    private String TerminalNumber;

    private String clientCard;

    private UUID orderDocId;

    private String orderDocCode;

    private String extraInfo;
}
