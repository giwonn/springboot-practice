package com.alphacode.handson.web.apis.v1.admin.service;

import com.alphacode.handson.web.apis.v1.admin.model.Admin;
import com.alphacode.handson.web.apis.v1.admin.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

	private final AdminRepository repository;

	public AdminService(AdminRepository repository) {
		this.repository = repository;
	}

	public List<Admin> list() {
		return repository.findAll();
	}
}
