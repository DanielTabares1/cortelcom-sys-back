package dani.cortelcomback.controller;

import dani.cortelcomback.Service.impl.InvoiceService;
import dani.cortelcomback.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cortelcom/api/invoices/")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/")
    public ResponseEntity<List<Invoice>> listInvoices(){
        List<Invoice> invoices = invoiceService.findAllInvoices();
        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> findInvoiceById(@PathVariable int id){
        Invoice invoice = invoiceService.findInvoiceById(id);
        return ResponseEntity.ok(invoice);
    }

    @GetMapping("/by-service/{serviceId}")
    public ResponseEntity<List<Invoice>> listInvoicesByService(Integer serviceId){
        List<Invoice> invoices = invoiceService.findAllInvoicesByService(serviceId);
        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/by-client/{clientId}")
    public ResponseEntity<List<Invoice>> listInvoicesByClient(Integer clientId){
        List<Invoice> invoices = invoiceService.findAllInvoicesByClientId(clientId);
        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/by-date/")
    public ResponseEntity<List<Invoice>> listInvoicesByMonthAndYear(@RequestParam int month, @RequestParam int year){
        List<Invoice> invoices = invoiceService.findAllInvoicesByDate(month - 1, year);
        return ResponseEntity.ok(invoices);
    }

    @PostMapping("/")
    public ResponseEntity<Invoice> addInvoice(@RequestBody Invoice invoice){
        Invoice addedInvoice = invoiceService.saveInvoice(invoice);
        return ResponseEntity.ok(addedInvoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> editInvoice(@PathVariable int id, @RequestBody Invoice invoice){
        Invoice existingInvoice = invoiceService.findInvoiceById(id);
        existingInvoice.setAmount_billed(invoice.getAmount_billed());
        existingInvoice.setClient(invoice.getClient());
        existingInvoice.setService(invoice.getService());
        existingInvoice.setGenerationDate(invoice.getGenerationDate());
        existingInvoice.setPayment_limit_date(invoice.getPayment_limit_date());
        invoiceService.saveInvoice(existingInvoice);
        return ResponseEntity.ok(existingInvoice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Invoice> deleteInvoice(@PathVariable int id){
        Invoice invoice = invoiceService.findInvoiceById(id);
        invoiceService.deleteInvoice(invoice);
        return ResponseEntity.ok(invoice);
    }

}
