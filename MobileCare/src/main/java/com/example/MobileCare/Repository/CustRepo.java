package com.example.MobileCare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MobileCare.Entity.Customer;

@Repository
public interface CustRepo extends JpaRepository<Customer, Long>{

	boolean existsByEmail(String email);

	boolean existsByPhone(Long phone);

	Customer findByEmail(String username);

	boolean existsByEmailAndPassword(String username, String password);

	boolean existsByPhoneAndPassword(String username, String password);

	Customer findByPhone(String username);

}
