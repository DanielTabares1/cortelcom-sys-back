package dani.cortelcomback.Service;

import dani.cortelcomback.model.Invoice;

import java.util.List;

public interface IInvoiceService {
    public List<Invoice> findAllInvoices();
    public Invoice findInvoiceById(Integer invoiceId);
    public Invoice saveInvoice(Invoice invoice);
    public void deleteInvoice(Invoice invoice);
}
