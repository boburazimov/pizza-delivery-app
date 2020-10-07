package uz.crm.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.crm.system.entity.catalogs.Customer;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqCustomer;
import uz.crm.system.payload.ResCustomer;
import uz.crm.system.payload.ResPageable;
import uz.crm.system.repository.CustomerRepository;
import uz.crm.system.repository.rest.CustomerGroupRepository;
import uz.crm.system.utils.CommonUtils;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerGroupRepository customerGroupRepository;

    @Override
    public ApiResponse addCustomer(ReqCustomer request, User user) {

        try {
            Customer customer = new Customer();
            if (request.getId() != null)
                customer = customerRepository.findById(request.getId()).orElseThrow(() -> new ResourceNotFoundException("getCustomer"));
            customer.setFullName(request.getFullName());
            customer.setGender(request.getGender());
            customer.setBirthDate(request.getBirthDate());
            customer.setGroup(request.getGroupId() == null ? null : customerGroupRepository.findById(request.getGroupId()).orElseThrow(() -> new ResourceNotFoundException("getCustomerGroup")));
            customer.setPhoneNumber(request.getPhoneNumber());
            customer.setExtraInfo(request.getExtraInfo());
            customerRepository.save(customer);
            return new ApiResponse(request.getId() == null ? "Клиент сохранен!" : "Клиент изменен!", true);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false);
        }
    }

    @Override
    public ResCustomer getCustomer(Customer customer) {

        return new ResCustomer(
                customer.getId(),
                customer.getFullName(),
                customer.getGender(),
                customer.getBirthDate(),
                customer.getGroup() == null ? null : customer.getGroup().getId(),
                customer.getGroup() == null ? null : customer.getGroup().getName(),
                customer.getPhoneNumber(),
                customer.getExtraInfo()
        );
    }

    @Override
    public ResPageable getCustomers(int page, int size, boolean sort) throws BadRequestException {

        CommonUtils.getPageable(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<Customer> customerPage = customerRepository.findAll(pageable);
        return new ResPageable(
                customerPage.getTotalPages(),
                customerPage.getTotalElements(),
                page,
                customerPage.getContent().stream().map(this::getCustomer).collect(Collectors.toList()));
    }

    @Override
    public ApiResponse deleteCustomer(UUID id) {

        try {
            Customer customer = customerRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("getCustomer"));
            // need logic code for cleaning BasketDoc from Customer
            customer.setCarts(null);
            customerRepository.deleteById(id);
            return new ApiResponse("Объект удален!", true);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false);
        }
    }
}
