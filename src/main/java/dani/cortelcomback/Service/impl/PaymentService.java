package dani.cortelcomback.Service.impl;

import dani.cortelcomback.Service.IPaymentService;
import dani.cortelcomback.model.Payment;
import dani.cortelcomback.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findPaymentById(Integer paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Payment payment) {
        paymentRepository.delete(payment);
    }
}
