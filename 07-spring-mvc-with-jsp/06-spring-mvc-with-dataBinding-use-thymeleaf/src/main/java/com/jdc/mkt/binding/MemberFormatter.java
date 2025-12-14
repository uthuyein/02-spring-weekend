package com.jdc.mkt.binding;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.jdc.mkt.model.entity.Member;
import com.jdc.mkt.model.repo.MemberRepo;

@Component
public class MemberFormatter implements Formatter<Member>{
	@Autowired
	private MemberRepo repo;

	@Override
	public String print(Member object, Locale locale) {
		return Optional.ofNullable(object).map(obj -> obj.getName()).orElse("No Name ");
	}

	@Override
	public Member parse(String name, Locale locale) throws ParseException {
		System.out.println("Format From Member Object"+ repo.findFirstByName(name));
		
		return Optional.ofNullable(name)
				.filter(n -> !n.isEmpty())
				.map(n -> repo.findFirstByName(n))
				.orElse(null);
				
	}

}
