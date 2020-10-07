package uz.crm.system.service;

import uz.crm.system.entity.catalogs.Customer;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqCustomer;
import uz.crm.system.payload.ResCustomer;
import uz.crm.system.payload.ResPageable;

import java.util.UUID;

public interface CustomerService {

    ApiResponse addCustomer(ReqCustomer request, User user);

    ResCustomer getCustomer(Customer customer);

    ResPageable getCustomers(int page, int size, boolean sort) throws BadRequestException;

    ApiResponse deleteCustomer(UUID id);
}
