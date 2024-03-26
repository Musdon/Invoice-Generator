package com.musdon.invoicegenerator.controller;

import com.musdon.invoicegenerator.entity.Invoice;
import com.musdon.invoicegenerator.payload.GenerateInvoiceRequest;
import com.musdon.invoicegenerator.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/invoice")
@AllArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping
    public Invoice generateInvoice(@RequestBody GenerateInvoiceRequest request){
        return invoiceService.generateInvoice(request);
    }

    @GetMapping
    public Invoice viewInvoiceDetails(@RequestParam String invoiceLink){
        return invoiceService.viewInvoiceDetails(invoiceLink);
    }
}
