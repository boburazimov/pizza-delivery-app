package uz.crm.system.service;

import org.springframework.stereotype.Service;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.entity.documents.OrderDoc;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqOrderDoc;
import uz.crm.system.payload.ResOrderDoc;
import uz.crm.system.payload.ResPageable;

import java.util.UUID;

@Service
public class OrderDocServiceImpl implements OrderDocService {

    @Override
    public ApiResponse addOrderDoc(ReqOrderDoc request, User user) {
        return null;
    }

    @Override
    public ResOrderDoc getOrderDoc(OrderDoc orderDoc) {
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
