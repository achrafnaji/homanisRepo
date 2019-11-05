package com.spm.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="price")
	private Double price ;
	
	@Column(name="explanation")
	private String explanation;

}
