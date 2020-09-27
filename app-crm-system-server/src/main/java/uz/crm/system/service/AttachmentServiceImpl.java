package uz.crm.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uz.crm.system.entity.catalogs.Attachment;
import uz.crm.system.entity.catalogs.AttachmentContent;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ResUploadFile;
import uz.crm.system.repository.AttachmentContentRepository;
import uz.crm.system.repository.AttachmentRepository;

import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @Override
    public ApiResponse uploadFile(MultipartHttpServletRequest request) {

        try {
            Iterator<String> iterator = request.getFileNames();
            MultipartFile file = request.getFile(iterator.next());

            Attachment attachment = new Attachment();
            assert file != null;
            attachment.setName(file.getOriginalFilename());
            attachment.setContentType(file.getContentType());
            attachment.setSize(file.getSize());
            Attachment savedAttachment = attachmentRepository.save(attachment);

            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setAttachment(savedAttachment);
            attachmentContent.setContent(file.getBytes());
            attachmentContentRepository.save(attachmentContent);

            ResUploadFile resUploadFile = new ResUploadFile();
            resUploadFile.setFileId(savedAttachment.getId());
            resUploadFile.setFileName(savedAttachment.getName());
            resUploadFile.setFileType(savedAttachment.getContentType());
            resUploadFile.setSize(savedAttachment.getSize());
            resUploadFile.setFileDownloadUri(ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/file/").path(savedAttachment.getId().toString()).toUriString());

            return new ApiResponse("Файл сохранен!", true, resUploadFile);
        } catch (IOException e) {
            e.printStackTrace();
            return new ApiResponse(e.getMessage(), false, null);
        }
    }

    @Override
    public HttpEntity<?> getFile(UUID id) {

        Attachment attachment = attachmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("getFileId"));
        AttachmentContent attachmentContent = attachmentContentRepository.findByAttachmentId(id);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(attachment.getContentType()))
                .header(HttpHeaders.CONTENT_TYPE, "attachment; filename=\"" + attachment.getName() + "\"")
                .body(attachmentContent.getContent());
    }
}
