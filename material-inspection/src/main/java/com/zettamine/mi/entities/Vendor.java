package com.zettamine.mi.entities;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vendor {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vendor_generator")
	  @SequenceGenerator(name = "vendor_generator",sequenceName = "vendor_sequence",initialValue = 5001,allocationSize = 1)
	  private Integer vendorId;
	  private String vendorName;
	  private String phoneNumber;
	  private String state;
	  private String city;
	  private String email;
	  private String status = "active";
	  
	  

	  
	  
	 
}
