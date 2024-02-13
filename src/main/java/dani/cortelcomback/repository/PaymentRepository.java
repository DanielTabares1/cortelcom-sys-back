package dani.cortelcomback.repository;

import dani.cortelcomback.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    public List<Payment> findByInvoiceId(Integer invoiceId);
    public List<Payment> findByDateBetween(Date startDate, Date endDate);
}
