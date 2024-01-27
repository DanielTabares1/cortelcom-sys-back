package dani.cortelcomback.Service;

import dani.cortelcomback.model.PaymentMethod;

import java.util.List;

public interface IPaymentMethodService {
    public List<PaymentMethod> findAllPaymentMethods();
    public PaymentMethod findPaymentMethodById(Integer paymentMethodId);
    public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod);
    public void deletePaymentMethod(PaymentMethod paymentMethod);
}
