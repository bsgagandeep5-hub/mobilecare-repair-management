package com.example.MobileCare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MobileCare.Entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long>{

	boolean existsByEmail(String email);

	boolean existsByPhone(Long phone);

	Admin findByEmail(String username);

	boolean existsByEmailAndPassword(String username, String password);

	boolean existsByPhoneAndPassword(String username, String password);

	Admin findByPhone(String username);

}
