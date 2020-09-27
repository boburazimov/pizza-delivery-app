package uz.crm.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crm.system.entity.catalogs.Product;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqProduct;
import uz.crm.system.repository.ProductRepository;
import uz.crm.system.security.CurrentUser;
import uz.crm.system.service.ProductService;
import uz.crm.system.utils.AppConstants;

import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public HttpEntity<?> addProduct(@RequestBody ReqProduct request, @CurrentUser User user) {
        ApiResponse response = productService.addProduct(request, user);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(response);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getProduct(@PathVariable UUID id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getProduct"));
        return ResponseEntity.ok(productService.getProduct(product));
    }

    @GetMapping
    public HttpEntity<?> getProducts(@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE) int page,
                                     @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_SIZE) int size,
                                     @RequestParam(value = "sort", defaultValue = "false") boolean sort) throws BadRequestException {
        return ResponseEntity.ok(productService.getProducts(page, size, sort));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteProduct(@PathVariable UUID id) {
        ApiResponse response = productService.deleteProduct(id);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(response);
    }
}
