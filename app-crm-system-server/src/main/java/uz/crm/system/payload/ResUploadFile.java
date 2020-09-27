package uz.crm.system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResUploadFile {

    private UUID fileId;
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private Long size;
}
