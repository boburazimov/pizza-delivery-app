package uz.crm.system.service;

import uz.crm.system.entity.catalogs.Address;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqAddress;
import uz.crm.system.payload.ResAddress;

import java.util.UUID;

public interface AddressService {

    ApiResponse addAddress(ReqAddress request, User user);

//    ResAddress getAddress(Address address);
//
//    ApiResponse deleteAddress(UUID id);
}
