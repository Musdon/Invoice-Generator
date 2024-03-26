package com.musdon.invoicegenerator.service;

import com.musdon.invoicegenerator.entity.Invoice;
import com.musdon.invoicegenerator.payload.GenerateInvoiceRequest;
import com.musdon.invoicegenerator.repository.InvoiceRepository;
import com.musdon.invoicegenerator.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InvoiceService {

    private InvoiceRepository invoiceRepository;

    public Invoice generateInvoice(GenerateInvoiceRequest request){
        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber("00" + invoice.getId());
        invoice.setAmount(request.getAmount());
        invoice.setUniqueInvoiceLink(generateInvoiceLink());
        invoice.setCustomerEmail(request.getCustomerEmail());

        invoice = invoiceRepository.save(invoice);
        return invoice;

    }
    
    public Invoice viewInvoiceDetails(String invoiceLink){
        Optional<Invoice> invoice = invoiceRepository.findByUniqueInvoiceLink(invoiceLink);
        Invoice retrievedInvoice = null;
        if (invoice.isPresent()){
            retrievedInvoice = invoice.get();
        }
        return retrievedInvoice;
    }
    public String generateInvoiceLink(){

        return "INV-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));

    }
}
