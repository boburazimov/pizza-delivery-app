package uz.crm.system.service;

import uz.crm.system.entity.catalogs.Client;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqClient;
import uz.crm.system.payload.ResClient;
import uz.crm.system.payload.ResPageable;

import java.util.UUID;

public interface ClientService {

    ApiResponse addClient(ReqClient request, User user);

    ResClient getClient(Client client);

    ResPageable getClients(int page, int size) throws BadRequestException;

    ApiResponse deleteClient(UUID id);
}
