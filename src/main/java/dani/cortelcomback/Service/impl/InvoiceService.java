package dani.cortelcomback.Service.impl;

import dani.cortelcomback.Service.IInvoiceService;
import dani.cortelcomback.model.Invoice;
import dani.cortelcomback.repository.InvoiceRepository;
import dani.cortelcomback.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceService implements IInvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    @Override
    public List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public List<Invoice> findAllInvoicesByClientId(Integer id) {
        return invoiceRepository.findByServiceClientId(id);
    }

    @Override
    public List<Invoice> findAllInvoicesByService(Integer serviceId) {
        return invoiceRepository.findByServiceId(serviceId);
    }

    @Override
    public List<Invoice> findAllInvoicesByDate(Integer year, Integer month) {
        DateUtil dateUtil = new DateUtil(year, month);
        Date startOfMonth = dateUtil.getStartOfMonth();
        Date endOfMonth = dateUtil.getEndOfMonth();
        return invoiceRepository.findByGenerationDateBetween(startOfMonth, endOfMonth);
    }

    @Override
    public List<Invoice> findAllInvoicesByDay(Integer year, Integer month, Integer day) {
        DateUtil dateUtil = new DateUtil(year, month, day);
        Date startOfDay = dateUtil.getStartOfDay();
        Date endOfDay = dateUtil.getEndOfDay();
        return invoiceRepository.findByGenerationDateBetween(startOfDay, endOfDay);
    }

    @Override
    public List<Invoice> findAllInvoicesByDateAndClientId(Integer year, Integer month, Integer id) {
        DateUtil dateUtil = new DateUtil(year, month);
        Date startOfMonth = dateUtil.getStartOfMonth();
        Date endOfMonth = dateUtil.getEndOfMonth();
        return invoiceRepository.findByGenerationDateBetweenAndClientId(startOfMonth, endOfMonth, id);
    }

    @Override
    public Invoice findInvoiceById(Integer invoiceId) {
        return invoiceRepository.findById(invoiceId).orElse(null);
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public void deleteInvoice(Invoice invoice) {
        invoiceRepository.delete(invoice);
    }
}
