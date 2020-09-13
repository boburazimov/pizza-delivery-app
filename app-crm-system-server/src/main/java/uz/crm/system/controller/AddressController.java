package uz.crm.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqAddress;
import uz.crm.system.security.CurrentUser;
import uz.crm.system.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public HttpEntity<?> addAddress(@RequestBody ReqAddress request, @CurrentUser User user) {
        ApiResponse response = addressService.addAddress(request, user);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(response);
    }
}
