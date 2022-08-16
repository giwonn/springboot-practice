package com.alphacode.handson.web.apis.v1.admin.model.dto;

import com.alphacode.handson.web.apis.v1.admin.model.Admin;
import com.alphacode.handson.web.apis.v1.model.BaseResponseDto;

import java.util.List;

public class AdminListResponseDto extends BaseResponseDto {

	private final List<Admin> admins;


	public AdminListResponseDto(List<Admin> admins) {
		this.admins = admins;
	}

	@Override
	public Object getData() {
		return null;
	}

	public static AdminListResponseDto of(List<Admin> admins) {
		return new AdminListResponseDto(admins);
	}


}
