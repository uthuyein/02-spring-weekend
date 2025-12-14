package com.jdc.mkt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.mkt.model.Member;

@Service
public class MemberServices {

	public List<Member> getMember() {
		return List.of(new Member(1, "John"), new Member(2, "William"), new Member(3, "Patrick"));
	}
}
