package dani.cortelcomback.Service;

import dani.cortelcomback.model.Payment;

import java.util.List;

public interface IPaymentService {
    public List<Payment> findAllPayments();
    public Payment findPaymentById(Integer paymentId);
    public Payment savePayment(Payment payment);
    public void deletePayment(Payment payment);
    public List<Payment> findPaymentByInvoiceId(Integer invoiceId);
    public List<Payment> findPaymentByMonth(Integer year, Integer month);
    public List<Payment> findPaymentByDay(Integer year, Integer month, Integer day);
}
