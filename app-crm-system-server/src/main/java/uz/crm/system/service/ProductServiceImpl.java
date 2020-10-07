package uz.crm.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.crm.system.entity.catalogs.Attachment;
import uz.crm.system.entity.catalogs.Product;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqProduct;
import uz.crm.system.payload.ResPageable;
import uz.crm.system.payload.ResProduct;
import uz.crm.system.repository.AttachmentContentRepository;
import uz.crm.system.repository.AttachmentRepository;
import uz.crm.system.repository.ProductRepository;
import uz.crm.system.repository.rest.CategoryRepository;
import uz.crm.system.repository.rest.SizeRepository;
import uz.crm.system.repository.rest.UnitRepository;
import uz.crm.system.utils.CommonUtils;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    UnitRepository unitRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;
    @Autowired
    SizeRepository sizeRepository;

    @Override
    public ApiResponse addProduct(ReqProduct request, User user) {

        try {
            Product product = new Product();
            if (request.getId() != null)
                product = productRepository.findById(request.getId()).orElseThrow(() -> new ResourceNotFoundException("getProduct"));
            product.setName(request.getName());
            product.setSizes(null);
            product.setCategory(categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("getCategory")));
            product.setTop(request.getTop());
            product.setBarcode(request.getBarcode());
            product.setArticle(request.getArticle());
            product.setPhoto(attachmentRepository.findById(request.getPhotoId()).orElseThrow(() -> new ResourceNotFoundException("getAttachment")));
            product.setUnit(unitRepository.findById(request.getUnitId()).orElseThrow(() -> new ResourceNotFoundException("getUnit")));
            productRepository.save(product);
            return new ApiResponse(request.getId() == null ? "Продукт сохранен!" : "Продукт изменен!", true);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false);
        }
    }

    @Override
    public ResProduct getProduct(Product product) {

//        return new ResProduct(
//                product.getId(),
//                product.getName(),
//                product.getProductSizes(),
//                product.getCategory().getId(),
//                product.getCategory().getName(),
//                product.getTop(),
//                product.getBarcode(),
//                product.getArticle(),
//                ServletUriComponentsBuilder
//                        .fromCurrentContextPath()
//                        .path("/api/file/")
//                        .path(attachmentRepository.findById(product.getPhoto().getId())
//                                .orElseThrow(() -> new ResourceNotFoundException("getPhoto"))
//                                .getId().toString()).toUriString(),
//                product.getUnit().getId(),
//                product.getUnit().getName()
//        );
        return null;
    }

    @Override
    public ResPageable getProducts(int page, int size, boolean sort) throws BadRequestException {

        CommonUtils.getPageable(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "createdAt");
        Page<Product> addressPage = productRepository.findAll(pageable);
        return new ResPageable(
                addressPage.getTotalPages(),
                addressPage.getTotalElements(),
                page,
                addressPage.getContent().stream().map(this::getProduct).collect(Collectors.toList()));
    }

    @Override
    public ApiResponse deleteProduct(UUID id) {

        try {
            Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getProduct"));
            Attachment productPhoto = product.getPhoto();
            product.setPhoto(null);
            productRepository.save(product);
            attachmentContentRepository.deleteByAttachment(productPhoto);
            attachmentRepository.delete(productPhoto);
            productRepository.deleteById(id);
            return new ApiResponse("Продукт удален!", true);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false);
        }
    }
}
