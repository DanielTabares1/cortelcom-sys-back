package dani.cortelcomback.Service;

import dani.cortelcomback.model.Client;

import java.util.List;

public interface IClientService {
    public List<Client> findAllClients();
    public Client findClientById(Integer clientId);
    public Client findClientByIdentification(String identification);
    public Client saveClient(Client client);
    public void deleteClient(Client client);
}
