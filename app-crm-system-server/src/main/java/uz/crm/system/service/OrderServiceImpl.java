package uz.crm.system.service;

import org.springframework.stereotype.Service;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.entity.documents.Order;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqOrder;
import uz.crm.system.payload.ResOrder;
import uz.crm.system.payload.ResPageable;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public ApiResponse addOrderDoc(ReqOrder request, User user) {
        return null;
    }

    @Override
    public ResOrder getOrderDoc(Order order) {
        return null;
    }

    @Override
    public ResPageable getOrderDocs(int page, int size, boolean sort) throws BadRequestException {
        return null;
    }

    @Override
    public ApiResponse deleteOrderDoc(UUID id) {
        return null;
    }
}
