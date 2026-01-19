package com.example.MobileCare.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MobileCare.Entity.Admin;
import com.example.MobileCare.Entity.Repair;

@Repository
public interface RepairRepo extends JpaRepository<Repair, Long>{
	
	@Query("select r from Repair r where r.admin = :admin order by r.date desc")
	List<Repair> findAllByAdmin(@Param("admin")Admin admin);
}
