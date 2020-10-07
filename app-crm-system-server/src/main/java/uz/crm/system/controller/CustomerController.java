package uz.crm.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crm.system.entity.catalogs.Customer;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqCustomer;
import uz.crm.system.repository.CustomerRepository;
import uz.crm.system.security.CurrentUser;
import uz.crm.system.service.CustomerService;
import uz.crm.system.utils.AppConstants;

import java.util.UUID;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;

    @PostMapping
    public HttpEntity<?> addCustomer(@RequestBody ReqCustomer request, @CurrentUser User user) {
        ApiResponse response = customerService.addCustomer(request, user);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(response);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getCustomer(@PathVariable UUID id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getCustomer"));
        return ResponseEntity.ok(customerService.getCustomer(customer));
    }

    @GetMapping
    public HttpEntity<?> getCustomers(@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE) int page,
                                      @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_SIZE) int size,
                                      @RequestParam(value = "sort", defaultValue = "false") boolean sort) throws BadRequestException {
        return ResponseEntity.ok(customerService.getCustomers(page, size, sort));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCustomer(@PathVariable UUID id) {
        ApiResponse response = customerService.deleteCustomer(id);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(response);
    }
}
