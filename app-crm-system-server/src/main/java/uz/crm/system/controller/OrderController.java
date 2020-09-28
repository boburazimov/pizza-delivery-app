package uz.crm.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.entity.documents.Order;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqOrder;
import uz.crm.system.repository.OrderRepository;
import uz.crm.system.security.CurrentUser;
import uz.crm.system.service.OrderService;
import uz.crm.system.utils.AppConstants;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @PostMapping
    public HttpEntity<?> addOrder(@RequestBody ReqOrder request, @CurrentUser User user) {
        ApiResponse response = orderService.addOrder(request, user);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(response);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOrder(@PathVariable UUID id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getOrder"));
        return ResponseEntity.ok(orderService.getOrder(order));
    }

    @GetMapping
    public HttpEntity<?> getOrders(@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE) int page,
                                      @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_SIZE) int size,
                                      @RequestParam(value = "sort", defaultValue = "false") boolean sort) throws BadRequestException {
        return ResponseEntity.ok(orderService.getOrders(page, size, sort));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteOrder(@PathVariable UUID id) {
        ApiResponse response = orderService.deleteOrder(id);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(response);
    }
}
