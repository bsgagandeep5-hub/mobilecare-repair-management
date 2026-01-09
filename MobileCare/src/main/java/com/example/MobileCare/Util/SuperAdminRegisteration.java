package com.example.MobileCare.Util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.MobileCare.Entity.Admin;
import com.example.MobileCare.Repository.AdminRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class SuperAdminRegisteration implements CommandLineRunner{

	private final AdminRepo adminRepo;
	
	@Override
	public void run(String... args) throws Exception {
		if(!adminRepo.existsByRole("SuperAdmin")) {
			Admin admin = new Admin();
			admin.setEmail("admin@gmail.com");
			admin.setName("Admin");
			admin.setPassword("Gagan@123");
			admin.setPhone(9876543210L);
			admin.setRole("SuperAdmin");
			adminRepo.save(admin);
			log.info("Admin Registered Successfully!..");
		}else {
			log.info("Admin exists!..");
		}
	}

}
