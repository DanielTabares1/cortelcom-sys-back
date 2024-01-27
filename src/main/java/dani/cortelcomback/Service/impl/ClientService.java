package dani.cortelcomback.Service.impl;

import dani.cortelcomback.Service.IClientService;
import dani.cortelcomback.model.Client;
import dani.cortelcomback.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client findClientById(Integer clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }
}
