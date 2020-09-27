package uz.crm.system.service;

import uz.crm.system.entity.catalogs.User;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqPayment;

public interface PaymentService {

    ApiResponse addPayment(ReqPayment reqPayment, User user);
}
