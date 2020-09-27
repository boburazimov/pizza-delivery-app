package uz.crm.system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResProduct {

    private UUID id;

    private String name;

    private Double size;

    private Integer categoryId;

    private String categoryName;

    private Boolean top;

    private String barcode;

    private String article;

    private String photoId;

    private Integer unitId;

    private String unitName;
}
