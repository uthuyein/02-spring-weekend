package com.jdc.mkt.binding;

import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jdc.mkt.model.Member;
import com.jdc.mkt.services.MemberServices;

@Component
public class MemberConverter implements Converter<String, Member>{

	@Autowired
	private MemberServices service;
	
	@Override
	public @Nullable Member convert(String id) {
		
		return service.getMember()
				.stream().filter(m -> m.id() == Optional.ofNullable(id).filter(i -> !i.isEmpty()).map(Integer ::parseInt).get())
				.findFirst().orElse(null);
				
		
	}

}
