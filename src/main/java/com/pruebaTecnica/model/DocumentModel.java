package com.pruebaTecnica.model;

import org.springframework.web.multipart.MultipartFile;

public class DocumentModel {

private String name;
	
	private String path;

	private MultipartFile file;
	
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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public DocumentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocumentModel(String name, String path, MultipartFile file) {
		super();
		this.name = name;
		this.path = path;
		this.file = file;
	}
}
