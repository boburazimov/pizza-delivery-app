package uz.crm.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.crm.system.entity.catalogs.Client;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqClient;
import uz.crm.system.payload.ResClient;
import uz.crm.system.payload.ResPageable;
import uz.crm.system.repository.ClientRepository;
import uz.crm.system.repository.rest.ClientGroupRepository;
import uz.crm.system.utils.CommonUtils;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ClientGroupRepository clientGroupRepository;

    @Override
    public ApiResponse addClient(ReqClient request, User user) {

        try {
            Client client = new Client();
            if (request.getId() != null)
                client = clientRepository.findById(request.getId()).orElseThrow(() -> new ResourceNotFoundException("getClient"));
            client.setFullName(request.getFullName());
            client.setGender(request.getGender());
            client.setBirthDate(request.getBirthDate());
            client.setGroup(request.getGroupId() == null ? null : clientGroupRepository.findById(request.getGroupId()).orElseThrow(() -> new ResourceNotFoundException("getClientGroup")));
            client.setPhoneNumber(request.getPhoneNumber());
            client.setExtraInfo(request.getExtraInfo());
            clientRepository.save(client);
            return new ApiResponse(request.getId() == null ? "Клиент сохранен!" : "Клиент изменен!", true);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false);
        }
    }

    @Override
    public ResClient getClient(Client client) {

        return new ResClient(
                client.getId(),
                client.getFullName(),
                client.getGender(),
                client.getBirthDate(),
                client.getGroup() == null ? null : client.getGroup().getId(),
                client.getGroup() == null ? null : client.getGroup().getName(),
                client.getPhoneNumber(),
                client.getExtraInfo()
        );
    }

    @Override
    public ResPageable getClients(int page, int size, boolean sort) throws BadRequestException {

        CommonUtils.getPageable(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<Client> clientPage = clientRepository.findAll(pageable);
        return new ResPageable(
                clientPage.getTotalPages(),
                clientPage.getTotalElements(),
                page,
                clientPage.getContent().stream().map(this::getClient).collect(Collectors.toList()));
    }

    @Override
    public ApiResponse deleteClient(UUID id) {

        try {
            Client client = clientRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("getClient"));
            // need logic code for cleaning BasketDoc from Client
            client.setCarts(null);
            clientRepository.deleteById(id);
            return new ApiResponse("Объект удален!", true);
        } catch (Exception e) {
            return new ApiResponse(e.getMessage(), false);
        }
    }
}
