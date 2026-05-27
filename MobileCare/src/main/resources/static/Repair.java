package com.example.MobileCare.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Repair {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rid;
	@Column(name = "repairId", unique = true)
	private String repairId;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Admin admin;
	private String issue;
	private String brand;
	private String model;
	private double cost;
	private String status;
	
	private LocalDate date;
}
