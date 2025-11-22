package com.jdc.mkt.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.model.entity.InvoiceItem;
import com.jdc.mkt.model.entity.InvoiceItemPk;

public interface InvoiceItemRepo extends JpaRepository<InvoiceItem, InvoiceItemPk>{

}
