package uz.crm.system.service;

import org.springframework.http.HttpEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.crm.system.payload.ApiResponse;

import java.util.UUID;

public interface AttachmentService {

    ApiResponse uploadFile(MultipartHttpServletRequest request);

    HttpEntity<?> getFile(UUID id);
}
