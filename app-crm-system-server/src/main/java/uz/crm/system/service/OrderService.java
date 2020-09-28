package uz.crm.system.service;

import uz.crm.system.entity.catalogs.User;
import uz.crm.system.entity.documents.Order;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqOrder;
import uz.crm.system.payload.ResOrder;
import uz.crm.system.payload.ResPageable;

import java.util.UUID;

public interface OrderService {

    ApiResponse addOrder(ReqOrder request, User user);

    ResOrder getOrder(Order order);

    ResPageable getOrders(int page, int size, boolean sort) throws BadRequestException;

    ApiResponse deleteOrder(UUID id);
}
