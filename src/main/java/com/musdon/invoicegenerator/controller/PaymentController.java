package com.musdon.invoicegenerator.controller;

import com.musdon.invoicegenerator.payload.PaymentRequest;
import com.musdon.invoicegenerator.payload.ProcessedInvoice;
import com.musdon.invoicegenerator.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    public ProcessedInvoice processPayment(@RequestBody PaymentRequest request){
        return paymentService.processPayment(request);
    }
}
