package com.musdon.invoicegenerator.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenerateInvoiceRequest {
    private double amount;
    private String customerEmail;
}
