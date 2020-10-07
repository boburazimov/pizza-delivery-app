package uz.crm.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.crm.system.entity.catalogs.Address;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqAddress;
import uz.crm.system.payload.ResAddress;
import uz.crm.system.payload.ResPageable;
import uz.crm.system.repository.AddressRepository;
import uz.crm.system.repository.CustomerRepository;
import uz.crm.system.repository.rest.DistrictRepository;
import uz.crm.system.utils.CommonUtils;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    DistrictRepository districtRepository;

    @Override
    public ApiResponse addAddress(ReqAddress request, User user) {

        try {
            Address address = new Address();
            if (request.getId() != null)
                address = addressRepository.findById(request.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("getAddress"));
            address.setCustomer(customerRepository.findById(request.getCustomerId())
                    .orElseThrow(() -> new ResourceNotFoundException("getCustomerId")));
            address.setDistrict(districtRepository.findById(request.getDistrictId())
                    .orElseThrow(() -> new ResourceNotFoundException("getDistrictId")));
            address.setStreetHome(request.getStreetHome());
            address.setExtraAddress(request.getExtraAddress());
            address.setLatitude(request.getLatitude());
            address.setLongitude(request.getLongitude());
            addressRepository.save(address);
            return new ApiResponse(request.getId() == null ? "Адресс сохранен!" : "Адресс изменен!", true);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false);
        }
    }

    @Override
    public ResAddress getAddress(Address address) {

        return new ResAddress(
                address.getId(),
                address.getCustomer().getId(),
                address.getCustomer().getFullName(),
                address.getDistrict() == null ? null : address.getDistrict().getId(),
                address.getDistrict() == null ? null : address.getDistrict().getName(),
                address.getStreetHome(),
                address.getExtraAddress(),
                address.getLatitude(),
                address.getLongitude()
        );
    }

    @Override
    public ResPageable getAddresses(int page, int size, boolean sort) throws BadRequestException {

        CommonUtils.getPageable(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<Address> addressPage = addressRepository.findAll(pageable);
        return new ResPageable(
                addressPage.getTotalPages(),
                addressPage.getTotalElements(),
                page,
                addressPage.getContent().stream().map(this::getAddress).collect(Collectors.toList()));
    }

    @Override
    public ApiResponse deleteAddress(UUID id) {

        try {
            Address address = addressRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("getAddress"));
            addressRepository.delete(address);
            return new ApiResponse("Адресс удален!", true);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false);
        }
    }
}
