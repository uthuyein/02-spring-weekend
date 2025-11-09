package com.jdc.mkt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.mkt.model.entity.Messenger;
import com.jdc.mkt.model.repo.MessengerRepo;

@Service
public class MessengerService {
	
	@Autowired
	private MessengerRepo repo;

	public List<Messenger> getAllMessages() {
		return repo.findAll();
	}
}
