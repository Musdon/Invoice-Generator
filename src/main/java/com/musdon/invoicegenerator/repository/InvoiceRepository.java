package com.musdon.invoicegenerator.repository;

import com.musdon.invoicegenerator.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Optional<Invoice> findByUniqueInvoiceLink(String invoiceLink);
}
