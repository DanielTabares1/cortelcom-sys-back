package dani.cortelcomback.repository;

import dani.cortelcomback.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    public List<Invoice> findByServiceId(Integer id);
    public List<Invoice> findByServiceClientId(Integer id);
}
