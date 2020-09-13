package uz.crm.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.crm.system.entity.catalogs.Client;
import uz.crm.system.entity.catalogs.User;
import uz.crm.system.exception.BadRequestException;
import uz.crm.system.payload.ApiResponse;
import uz.crm.system.payload.ReqClient;
import uz.crm.system.repository.ClientRepository;
import uz.crm.system.security.CurrentUser;
import uz.crm.system.service.ClientService;
import uz.crm.system.utils.AppConstants;

import java.util.UUID;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;
    @Autowired
    ClientRepository clientRepository;

    @PostMapping
    public HttpEntity<?> addClient(@RequestBody ReqClient request, @CurrentUser User user) {
        ApiResponse response = clientService.addClient(request, user);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(response);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getClient(@PathVariable UUID id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getClient"));
        return ResponseEntity.ok(clientService.getClient(client));
    }

    @GetMapping
    public HttpEntity<?> getClients(@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE) int page,
                                    @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_SIZE) int size) throws BadRequestException {
        return ResponseEntity.ok(clientService.getClients(page, size));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteClient(@PathVariable UUID id) {
        ApiResponse response = clientService.deleteClient(id);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(response);
    }
}
