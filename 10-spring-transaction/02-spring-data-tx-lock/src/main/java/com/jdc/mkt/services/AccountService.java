package com.jdc.mkt.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.entity.Account;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;

@Service
public class AccountService {

	@PersistenceContext
	EntityManager em;

	@Transactional
	public Account find(int id) {
		var acc = em.find(Account.class, id, LockModeType.OPTIMISTIC);
		return acc;
	}
}
