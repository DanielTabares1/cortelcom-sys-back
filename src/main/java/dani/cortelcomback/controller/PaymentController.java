package dani.cortelcomback.controller;

import dani.cortelcomback.Service.impl.PaymentService;
import dani.cortelcomback.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cortelcom/api/payments/")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/")
    public ResponseEntity<List<Payment>> getAllPayments(){
        List<Payment> payments = paymentService.findAllPayments();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id){
        Payment payment = paymentService.findPaymentById(id);
        //TODO -> catch payment not found exception
        return ResponseEntity.ok(payment);
    }

    @PostMapping("/")
    public ResponseEntity<Payment> postPayment(@RequestBody Payment payment){
        Payment addedPayment = paymentService.savePayment(payment);
        return ResponseEntity.ok(addedPayment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> putPayment(@PathVariable int id, @RequestBody Payment payment){
        Payment existingPayment = paymentService.findPaymentById(id);
        existingPayment.setDate(payment.getDate());
        existingPayment.setInvoice(payment.getInvoice());
        paymentService.savePayment(existingPayment);
        return ResponseEntity.ok(existingPayment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Payment> deletePayment(@PathVariable int id){
        Payment existingPayment = paymentService.findPaymentById(id);
        paymentService.deletePayment(existingPayment);
        return ResponseEntity.ok(existingPayment);
    }

    @GetMapping("/by-invoice/{id}")
    public ResponseEntity<List<Payment>> findPaymentByInvoiceId(@PathVariable int id){
        List<Payment> payments = paymentService.findPaymentByInvoiceId(id);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/by-date/by-month/")
    public ResponseEntity<List<Payment>> findPaymentByMonth(@RequestParam int year, @RequestParam int month){
        List<Payment> payments = paymentService.findPaymentByMonth(year, month - 1);
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/by-date/by-day/")
    public ResponseEntity<List<Payment>> findPaymentByDay(@RequestParam int year, @RequestParam int month, @RequestParam int day){
        List<Payment> payments = paymentService.findPaymentByDay(year, month - 1, day);
        return ResponseEntity.ok(payments);
    }



}
