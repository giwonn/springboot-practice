package com.alphacode.handson.web.apis.v1.admin.repository;

import com.alphacode.handson.web.apis.v1.admin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
}
