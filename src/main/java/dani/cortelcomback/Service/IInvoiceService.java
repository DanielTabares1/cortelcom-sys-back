package dani.cortelcomback.Service;

import dani.cortelcomback.model.Invoice;

import java.util.List;

public interface IInvoiceService {
    List<Invoice> findAllInvoices();

    List<Invoice> findAllInvoicesByClientId(Integer id);

    List<Invoice> findAllInvoicesByService(Integer serviceId);

    List<Invoice> findAllInvoicesByDate(Integer year, Integer month);

    List<Invoice> findAllInvoicesByDay(Integer year, Integer month, Integer day);

    List<Invoice> findAllInvoicesByDateAndClientId(Integer year, Integer month, Integer id);

    List<Invoice> findAllInvoicesByDayAndClientId(Integer year, Integer month, Integer day, Integer id);

    Invoice findInvoiceById(Integer invoiceId);

    Invoice saveInvoice(Invoice invoice);

    void deleteInvoice(Invoice invoice);
}
