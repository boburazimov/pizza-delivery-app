package uz.crm.system.service;

import uz.crm.system.entity.catalogs.User;
import uz.crm.system.entity.documents.OrderDoc;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqOrderDoc;
import uz.crm.system.payload.ResOrderDoc;
import uz.crm.system.payload.ResPageable;

import java.util.UUID;

public interface OrderDocService {

    ApiResponse addOrderDoc(ReqOrderDoc request, User user);

    ResOrderDoc getOrderDoc(OrderDoc orderDoc);

    ResPageable getOrderDocs(int page, int size, boolean sort) throws BadRequestException;

    ApiResponse deleteOrderDoc(UUID id);
}
