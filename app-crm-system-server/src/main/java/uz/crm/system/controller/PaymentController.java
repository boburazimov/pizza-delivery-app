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
import uz.crm.system.payload.ReqPayment;
import uz.crm.system.security.CurrentUser;
import uz.crm.system.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public HttpEntity<?> addPayment(@RequestBody ReqPayment request, @CurrentUser User user) {
        ApiResponse response = paymentService.addPayment(request, user);
        return ResponseEntity.status(
                response.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(response);
    }
}
