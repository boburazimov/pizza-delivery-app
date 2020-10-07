package uz.crm.system.service;

import uz.crm.system.entity.catalogs.Payment;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqPayment;
import uz.crm.system.payload.ResPageable;
import uz.crm.system.payload.ResPayment;

import java.util.UUID;

public interface PaymentService {

    ApiResponse addPayment(ReqPayment reqPayment, User user);

    ResPayment getPayment(Payment payment);

    ResPageable getPayments(int page, int size, boolean sort) throws BadRequestException;

    ApiResponse deletePayment(UUID id);
}
