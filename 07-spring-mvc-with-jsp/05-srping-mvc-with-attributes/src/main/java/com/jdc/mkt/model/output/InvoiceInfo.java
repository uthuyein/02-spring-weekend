package com.jdc.mkt.model.output;

import java.time.LocalDateTime;
import java.util.UUID;

public record InvoiceInfo(
		 UUID id,
		 int totalCount,
		 Double totalAmount,
		 LocalDateTime issuedDt
		) {

}
