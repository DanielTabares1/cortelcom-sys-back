package dani.cortelcomback.Service.impl;

import dani.cortelcomback.Service.IServiceService;
import dani.cortelcomback.model.Service;
import dani.cortelcomback.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ClientService clientService;

    @Override
    public List<Service> findAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public List<Service> findServicesByClientId(Integer clientId) {
        return serviceRepository.findByClientId(clientId);
    }

    @Override
    public Service findServiceById(Integer serviceId) {
        return serviceRepository.findById(serviceId).orElse(null);
    }

    @Override
    public Service saveService(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public void deleteService(Service service) {
        serviceRepository.delete(service);
    }
}
