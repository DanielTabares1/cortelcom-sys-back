package dani.cortelcomback.controller;

import dani.cortelcomback.Service.impl.PaymentMethodService;
import dani.cortelcomback.model.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cortelcom/api/pay-methods/")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping("/")
    public ResponseEntity<List<PaymentMethod>> listMethods(){
        List<PaymentMethod> paymentMethods = paymentMethodService.findAllPaymentMethods();
        return ResponseEntity.ok(paymentMethods);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable int id){
        PaymentMethod paymentMethod = paymentMethodService.findPaymentMethodById(id);
        return ResponseEntity.ok(paymentMethod);
    }

    @PostMapping("/")
    public ResponseEntity<PaymentMethod> addPaymentMethod(@RequestBody PaymentMethod paymentMethod){
        PaymentMethod addedPaymentMethod = paymentMethodService.savePaymentMethod(paymentMethod);
        return ResponseEntity.ok(addedPaymentMethod);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentMethod> editPaymentMethod(@PathVariable int id, @RequestBody PaymentMethod paymentMethod){
        PaymentMethod existingPaymentMethod = paymentMethodService.findPaymentMethodById(id);
        paymentMethod.setId(existingPaymentMethod.getId());
        paymentMethodService.savePaymentMethod(paymentMethod);
        return ResponseEntity.ok(paymentMethod);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentMethod> deletePaymentMethod(@PathVariable int id){
        PaymentMethod paymentMethod = paymentMethodService.findPaymentMethodById(id);
        paymentMethodService.deletePaymentMethod(paymentMethod);
        return ResponseEntity.ok(paymentMethod);
    }

}
