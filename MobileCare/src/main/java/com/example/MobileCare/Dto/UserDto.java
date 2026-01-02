package com.example.MobileCare.Dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Component
@Data
public class UserDto {
	
	@NotBlank(message = "* Name is required")
	@Size(min = 3, max = 25, message=  "* Enter between 3~25 characters")
	private String name;
	
	@NotBlank(message = "* Email is required")
	@Email(message = "* Enter correcr Email")
	private String email;
	
	@NotNull(message = "* Phone number is required")
	@Min(6000000000L)
	@Max(9999999999L)
	private Long phone;
	
	@NotBlank(message = "* Password is required")
	@Pattern(
	    regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$",
	    message = "* Password must have uppercase, lowercase, digit, special character and be 8+ characters"
	)
	private String password;
	
	private String confirmPassword;
	
	@NotNull(message = "* Role is required")
	private String role;
}
