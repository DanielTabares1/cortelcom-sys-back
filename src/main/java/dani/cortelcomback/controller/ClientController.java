package dani.cortelcomback.controller;

import dani.cortelcomback.Service.impl.ClientService;
import dani.cortelcomback.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cortelcom/api/clients/")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public ResponseEntity<List<Client>> listClients(){
        List<Client> clients = clientService.findAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable int id){
        Client client = clientService.findClientById(id);
        //TODO - Client not found exception
        return ResponseEntity.ok(client);
    }

    @PostMapping("/")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        Client addedClient = clientService.saveClient(client);
        return ResponseEntity.ok(addedClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> editClient(@PathVariable int id, @RequestBody Client client){
        Client existingClient = clientService.findClientById(id);
        existingClient.setName(client.getName());
        existingClient.setLastName(client.getLastName());
        existingClient.setPhoneNumber(client.getPhoneNumber());
        clientService.saveClient(existingClient);
        return ResponseEntity.ok(existingClient);
    }


}
