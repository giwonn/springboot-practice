package com.alphacode.handson.web.apis.v1.admin;

import com.alphacode.handson.web.apis.v1.admin.model.dto.AdminListResponseDto;
import com.alphacode.handson.web.apis.v1.admin.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {

	private final AdminService service;

	public AdminController(AdminService service) {
		this.service = service;
	}

	public ResponseEntity<AdminListResponseDto> list() {
		var list = service.list();
		return ResponseEntity.ok(AdminListResponseDto.of(list));
	}
}
