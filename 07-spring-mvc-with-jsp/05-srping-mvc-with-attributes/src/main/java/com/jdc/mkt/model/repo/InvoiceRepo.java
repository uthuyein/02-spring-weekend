package com.jdc.mkt.model.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.model.entity.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, UUID>{

}
