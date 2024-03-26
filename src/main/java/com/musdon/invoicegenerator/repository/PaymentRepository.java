package com.musdon.invoicegenerator.repository;

import com.musdon.invoicegenerator.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
