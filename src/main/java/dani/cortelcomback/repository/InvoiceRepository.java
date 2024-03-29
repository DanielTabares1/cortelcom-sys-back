package dani.cortelcomback.repository;

import dani.cortelcomback.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    List<Invoice> findByServiceId(Integer id);

    List<Invoice> findByServiceClientId(Integer id);

    List<Invoice> findByGenerationDateBetween(Date startOfMonth, Date endOfMonth);

    List<Invoice> findByGenerationDateBetweenAndClientId(Date startOfMonth, Date endOfMonth, Integer clientId);
}
