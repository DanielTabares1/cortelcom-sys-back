package dani.cortelcomback.repository;

import dani.cortelcomback.model.Client;
import dani.cortelcomback.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    public List<Service> findByClientId(Integer clientId);
}
