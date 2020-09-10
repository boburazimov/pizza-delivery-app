package uz.crm.system.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private String message;

    private Boolean success;

    private Object object;

    public ApiResponse(String message, Boolean success) {
        this.message = message;
        this.success = success;
    }
}
