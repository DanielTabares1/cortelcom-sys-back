package dani.cortelcomback.Service;

import dani.cortelcomback.model.Service;

import java.util.List;

public interface IServiceService {
    public List<Service> findAllServices();
    public List<Service> findServicesByClientId(Integer clientId);
    public Service findServiceById(Integer serviceId);
    public Service saveService(Service service);
    public void deleteService(Service service);
}
