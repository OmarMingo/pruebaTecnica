package com.pruebaTecnica.entity;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "documents")
public class Document extends BaseEntity{

	private String name;
	
	private String path;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Document(String name, String path) {
		super();
		this.name = name;
		this.path = path;
	}

	
	
	
}
