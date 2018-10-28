package com.libo.springcloud.service;

import java.util.List;

import com.libo.springcloud.entities.Dept;

public interface DeptService {
	
	public boolean addDept(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
