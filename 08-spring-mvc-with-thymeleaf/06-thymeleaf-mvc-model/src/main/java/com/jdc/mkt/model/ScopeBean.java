package com.jdc.mkt.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "application",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ScopeBean {

	private int value;
	
	public int increase() {
		return  ++value;
	}
}
