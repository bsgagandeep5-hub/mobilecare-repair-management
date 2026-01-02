package com.example.MobileCare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MobileCare.Entity.Repair;

@Repository
public interface RepairRepo extends JpaRepository<Repair, Long>{

}
