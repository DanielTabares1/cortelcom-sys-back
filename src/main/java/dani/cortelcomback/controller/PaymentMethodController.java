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

    @PostMapping("/")
    public ResponseEntity<PaymentMethod> addPaymentMethod(@RequestBody PaymentMethod paymentMethod){
        PaymentMethod addedPaymentMethod = paymentMethodService.savePaymentMethod(paymentMethod);
        return ResponseEntity.ok(addedPaymentMethod);
    }

}