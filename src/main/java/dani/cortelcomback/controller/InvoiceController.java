package dani.cortelcomback.controller;

import dani.cortelcomback.Service.impl.InvoiceService;
import dani.cortelcomback.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cortelcom/api/invoices/")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/")
    public ResponseEntity<List<Invoice>> listInvoices(){
        List<Invoice> invoices = invoiceService.findAllInvoices();
        return ResponseEntity.ok(invoices);
    }

}
