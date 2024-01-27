package dani.cortelcomback.Service.impl;

import dani.cortelcomback.Service.IPaymentMethodService;
import dani.cortelcomback.model.PaymentMethod;
import dani.cortelcomback.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodService implements IPaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public List<PaymentMethod> findAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public PaymentMethod findPaymentMethodById(Integer paymentMethodId) {
        return paymentMethodRepository.findById(paymentMethodId).orElse(null);
    }

    @Override
    public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public void deletePaymentMethod(PaymentMethod paymentMethod) {
        paymentMethodRepository.delete(paymentMethod);
    }
}
