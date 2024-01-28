package dani.cortelcomback.Service.impl;

import dani.cortelcomback.Service.IInvoiceService;
import dani.cortelcomback.model.Invoice;
import dani.cortelcomback.repository.InvoiceRepository;
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
    public List<Invoice> findAllInvoicesByDate(Integer month, Integer year) {
        //Todo mover esta logic de aca pq no me gusta :(
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1, 0, 0, 0);
        calendar.add(Calendar.SECOND, -1);
        Date startOfMonth = calendar.getTime();
        logger.info(startOfMonth.toString());
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.SECOND, 2);
        Date endOfMonth = calendar.getTime();
        logger.info(endOfMonth.toString());
        return invoiceRepository.findByGenerationDateBetween(startOfMonth, endOfMonth);
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
