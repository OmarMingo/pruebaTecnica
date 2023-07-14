package com.pruebaTecnica.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pruebaTecnica.entity.Document;
import com.pruebaTecnica.model.DocumentModel;

@Service
public interface DocumentsService {

	void save(Document documento);
	
	void updateFile(DocumentModel documentoModel);
	
	String storeFile(MultipartFile files, String nombres);
	
	String upload(List<MultipartFile> files, List<String> nombres);
	
	void deleteFile(Long id);

}
