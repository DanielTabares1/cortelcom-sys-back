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

}
