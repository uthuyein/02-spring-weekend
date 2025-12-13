package com.jdc.mkt.binding;

import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jdc.mkt.model.entity.Member;
import com.jdc.mkt.model.repo.MemberRepo;

@Component
public class MemberConverter implements Converter<String, Member>{

	@Autowired
	private MemberRepo repo;
	
	@Override
	public @Nullable Member convert(String source) {
		return Optional.ofNullable(source)
				.filter(s -> !s.isEmpty())
				.map(Integer::parseInt)
				.flatMap(id -> repo.findById(id))
				.orElse(null);
		
	
		
	}

}
