package com.example.MobileCare.Dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Component
public class AddRepairDto {

	private long rid;
	
	@NotBlank(message = "* Name is required")
	@Size(min=3, max = 25, message="* Enter between 3~25 characters")
	@Pattern(regexp = "^[A-Za-z ]+$", message = "* Only alphabets allowed")
	private String custName;
	
	@NotNull(message = "* Phone number is required")
	@Min(value=6666666666L, message = "* Enter valid phone number")
	@Max(value=9999999999L, message = "* Enter valid phone number")
	private Long custPhone;
	
	@NotBlank(message = "* Enter issue")
	private String issue;
	
	@NotBlank(message = "* Enter brand")
	private String brand;
	
	@NotBlank(message = "* Enter model")
	private String model;
	
	@NotNull(message = "* Enter cost")
	private Double cost;
	
	//@NotBlank(message = "* Status is required")
	private String status = "Pending";
}
