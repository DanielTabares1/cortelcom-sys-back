package dani.cortelcomback.controller;

import dani.cortelcomback.Service.impl.ServiceService;
import dani.cortelcomback.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cortelcom/api/services/")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/")
    public ResponseEntity<List<Service>> listServices(){
        List<Service> services = serviceService.findAllServices();
        return ResponseEntity.ok(services);
    }

    @GetMapping("/by-client/{clientId}")
    public ResponseEntity<List<Service>> listServicesByClient(@PathVariable int clientId){
        List<Service> services = serviceService.findServicesByClientId(clientId);
        return ResponseEntity.ok(services);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> findServiceById(@PathVariable int id){
        Service service = serviceService.findServiceById(id);
        return ResponseEntity.ok(service);
    }

    @PostMapping("/")
    public ResponseEntity<Service> addService(@RequestBody Service service){
        Service addedService = serviceService.saveService(service);
        return ResponseEntity.ok(addedService);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> editService(@RequestBody Service service, @PathVariable int id){
        Service existingService = serviceService.findServiceById(id);
        existingService.setAddress(service.getAddress());
        existingService.setClient(service.getClient());
        existingService.setEnrollmentDate(service.getEnrollmentDate());
        existingService.setIsActive(service.getIsActive());
        existingService.setPaymentMethod(service.getPaymentMethod());
        serviceService.saveService(existingService);
        return ResponseEntity.ok(existingService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Service> deleteService(@PathVariable int id){
        Service service = serviceService.findServiceById(id);
        serviceService.deleteService(service);
        return ResponseEntity.ok(service);
    }

}
