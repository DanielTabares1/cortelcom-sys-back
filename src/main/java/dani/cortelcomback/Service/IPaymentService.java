package dani.cortelcomback.Service;

import dani.cortelcomback.model.Payment;

import java.util.List;

public interface IPaymentService {
    public List<Payment> findAllPayments();
    public Payment findPaymentById(Integer paymentId);
    public Payment savePayment(Payment payment);
    public void deletePayment(Payment payment);
}
