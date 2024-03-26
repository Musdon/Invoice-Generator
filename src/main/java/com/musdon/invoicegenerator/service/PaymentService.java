package com.musdon.invoicegenerator.service;

import com.musdon.invoicegenerator.entity.Invoice;
import com.musdon.invoicegenerator.entity.Payment;
import com.musdon.invoicegenerator.entity.PaymentStatus;
import com.musdon.invoicegenerator.payload.PaymentRequest;
import com.musdon.invoicegenerator.payload.ProcessedInvoice;
import com.musdon.invoicegenerator.repository.InvoiceRepository;
import com.musdon.invoicegenerator.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final InvoiceRepository invoiceRepository;

    public ProcessedInvoice processPayment(PaymentRequest request){
        Optional<Invoice> invoice = invoiceRepository.findByUniqueInvoiceLink(request.getInvoiceLink());
        Invoice invoiceToProcess = null;
        if (invoice.isPresent()){
            invoiceToProcess = invoice.get();
        }
        assert invoiceToProcess != null;
        Payment payment = Payment.builder()
                .amount(invoiceToProcess.getAmount())
                .paymentStatus(PaymentStatus.COMPLETED)
                .invoice(invoiceToProcess)
                .build();
        paymentRepository.save(payment);

        return ProcessedInvoice.builder()
                .payment(payment)
                .invoice(invoiceToProcess)
                .build();
    }
}
