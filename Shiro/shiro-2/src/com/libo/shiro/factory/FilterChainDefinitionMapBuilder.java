package com.libo.shiro.factory;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		
		map.put("/login.jsp", "anon");
		map.put("/shiro/login", "anon");
		map.put("/**", "authc");
		
		return map;
	}
}
