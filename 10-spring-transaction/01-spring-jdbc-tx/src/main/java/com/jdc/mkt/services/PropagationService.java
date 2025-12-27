package com.jdc.mkt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.repo.AccountRepo;
import com.jdc.mkt.repo.TypeRepo;

@Service
public class PropagationService {

	@Autowired
	private AccountRepo accRepo;
	@Autowired
	private TypeRepo typeRepo;

	
	public List<Integer> save(int error, String type, String... account) {

			int typeId = typeRepo.save(type);

			if (error == 1) {
				throw new RuntimeException();
			}

			var list = accRepo.save(typeId, account);

			if (error == 2) {
				throw new RuntimeException();
			}
			return list;
			
	}
}
