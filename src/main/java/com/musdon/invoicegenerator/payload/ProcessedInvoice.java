package com.musdon.invoicegenerator.payload;

import com.musdon.invoicegenerator.entity.Invoice;
import com.musdon.invoicegenerator.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcessedInvoice {
    private Payment payment;
    private Invoice invoice;
}
