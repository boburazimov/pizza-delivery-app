package uz.crm.system.service;

import org.springframework.stereotype.Service;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqAddress;

@Service
public class AddressServiceImpl implements AddressService {

    @Override
    public ApiResponse addAddress(ReqAddress request, User user) {
        return null;
    }
}
