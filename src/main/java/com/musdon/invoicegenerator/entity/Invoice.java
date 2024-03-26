package com.musdon.invoicegenerator.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String invoiceNumber;
    private double amount;
    private String customerEmail;
    private String uniqueInvoiceLink;
}
