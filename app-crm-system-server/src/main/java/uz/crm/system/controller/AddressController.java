package uz.crm.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crm.system.entity.catalogs.Address;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqAddress;
import uz.crm.system.repository.AddressRepository;
import uz.crm.system.security.CurrentUser;
import uz.crm.system.service.AddressService;
import uz.crm.system.utils.AppConstants;

import java.util.UUID;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;
    @Autowired
    AddressRepository addressRepository;

    @PostMapping
    public HttpEntity<?> addAddress(@RequestBody ReqAddress request, @CurrentUser User user) {
        ApiResponse response = addressService.addAddress(request, user);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(response);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getAddress(@PathVariable UUID id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getAddress"));
        return ResponseEntity.ok(addressService.getAddress(address));
    }

    @GetMapping
    public HttpEntity<?> getAddresses(@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE) int page,
                                      @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_SIZE) int size,
                                      @RequestParam(value = "sort", defaultValue = "false") boolean sort) throws BadRequestException {
        return ResponseEntity.ok(addressService.getAddresses(page, size, sort));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteAddress(@PathVariable UUID id) {
        ApiResponse response = addressService.deleteAddress(id);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(response);
    }
}
