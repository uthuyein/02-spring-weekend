package com.jdc.mkt.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.model.entity.Messenger;


public interface MessengerRepo extends JpaRepository<Messenger, Integer>{

}
