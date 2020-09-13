package uz.crm.system.service;

import org.springframework.stereotype.Service;
import uz.crm.system.entity.catalogs.Client;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqClient;
import uz.crm.system.payload.ResClient;
import uz.crm.system.payload.ResPageable;

import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public ApiResponse addClient(ReqClient request, User user) {
        return null;
    }

    @Override
    public ResClient getClient(Client client) {
        return null;
    }

    @Override
    public ResPageable getClients(int page, int size) {
        return null;
    }

    @Override
    public ApiResponse deleteClient(UUID id) {
        return null;
    }
}
