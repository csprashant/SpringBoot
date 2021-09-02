package com.nt.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer Id;
	
	@NotBlank(message = "Name can not be null")
	private String name;
	
	@NotBlank(message = "Percent can not be null")
	private String per;
}
