package com.example.MobileCare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MobileCare.Entity.Customer;

@Repository
public interface CustRepo extends JpaRepository<Customer, Long>{

}
