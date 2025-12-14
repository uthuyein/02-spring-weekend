package com.jdc.mkt.binding;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.jdc.mkt.model.Member;
import com.jdc.mkt.services.MemberServices;

@Component
public class MemberFormatter implements Formatter<Member> {

	@Autowired
	MemberServices service;
	
	@Override
	public String print(Member object, Locale locale) {
		return Optional.ofNullable(object).map(obj -> obj.name()).orElse(null);
	}

	@Override
	public Member parse(String id, Locale locale) throws ParseException {
		return service.getMember().stream()
				.filter(m -> m.id() == Integer.parseInt(id))
				.findFirst().orElse(null);
	}

}
