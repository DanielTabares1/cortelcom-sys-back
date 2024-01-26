package dani.cortelcomback.controller;

import dani.cortelcomback.Service.impl.ServiceService;
import dani.cortelcomback.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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

    @PostMapping("/")
    public ResponseEntity<Service> addService(@RequestBody Service service){
        Service addedService = serviceService.saveService(service);
        return ResponseEntity.ok(addedService);
    }

}
