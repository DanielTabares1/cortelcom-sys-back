package dani.cortelcomback.Service.impl;

import dani.cortelcomback.Service.IPaymentService;
import dani.cortelcomback.model.Payment;
import dani.cortelcomback.repository.PaymentRepository;
import dani.cortelcomback.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    Logger logger = LoggerFactory.getLogger(PaymentService.class);

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

    @Override
    public List<Payment> findPaymentByInvoiceId(Integer invoiceId) {
        return paymentRepository.findByInvoiceId(invoiceId);
    }

    @Override
    public List<Payment> findPaymentByMonth(Integer year, Integer month) {
        DateUtil dateUtil = new DateUtil(year, month);
        Date startOfMonth = dateUtil.getStartOfMonth();
        Date endOfMonth = dateUtil.getEndOfMonth();
        return paymentRepository.findByDateBetween(startOfMonth, endOfMonth);
    }

    @Override
    public List<Payment> findPaymentByDay(Integer year, Integer month, Integer day) {
        DateUtil dateUtil = new DateUtil(year, month, day);
        Date startOfDay = dateUtil.getStartOfDay();
        Date endOfDay = dateUtil.getEndOfDay();
        return paymentRepository.findByDateBetween(startOfDay, endOfDay);
    }

}
