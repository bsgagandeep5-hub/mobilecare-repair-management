package com.example.MobileCare.Dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AddRepairDto {

	private long rid;
	private String custName;
	private long custPhone;
	private String issue;
	private String brand;
	private String model;
	private double cost;
	private String status;
}
