package uz.crm.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.entity.documents.OrderDoc;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqOrderDoc;
import uz.crm.system.repository.OrderDocRepository;
import uz.crm.system.security.CurrentUser;
import uz.crm.system.service.OrderDocService;
import uz.crm.system.utils.AppConstants;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
public class OrderDocController {

    @Autowired
    OrderDocService orderDocService;
    @Autowired
    OrderDocRepository orderDocRepository;

    @PostMapping
    public HttpEntity<?> addOrderDoc(@RequestBody ReqOrderDoc request, @CurrentUser User user) {
        ApiResponse response = orderDocService.addOrderDoc(request, user);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(response);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOrderDoc(@PathVariable UUID id) {
        OrderDoc orderDoc = orderDocRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getOrderDoc"));
        return ResponseEntity.ok(orderDocService.getOrderDoc(orderDoc));
    }

    @GetMapping
    public HttpEntity<?> getOrderDocs(@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE) int page,
                                      @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_SIZE) int size,
                                      @RequestParam(value = "sort", defaultValue = "false") boolean sort) throws BadRequestException {
        return ResponseEntity.ok(orderDocService.getOrderDocs(page, size, sort));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteOrderDoc(@PathVariable UUID id) {
        ApiResponse response = orderDocService.deleteOrderDoc(id);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(response);
    }
}
