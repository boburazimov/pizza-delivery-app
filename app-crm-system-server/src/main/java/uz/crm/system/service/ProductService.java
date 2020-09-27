package uz.crm.system.service;

import uz.crm.system.entity.catalogs.Product;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqProduct;
import uz.crm.system.payload.ResPageable;
import uz.crm.system.payload.ResProduct;

import java.util.UUID;

public interface ProductService {

    ApiResponse addProduct(ReqProduct request, User user);

    ResProduct getProduct(Product product);

    ResPageable getProducts(int page, int size, boolean sort) throws BadRequestException;

    ApiResponse deleteProduct(UUID id);
}
