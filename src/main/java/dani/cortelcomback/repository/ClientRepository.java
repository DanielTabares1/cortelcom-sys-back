package dani.cortelcomback.repository;

import dani.cortelcomback.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
