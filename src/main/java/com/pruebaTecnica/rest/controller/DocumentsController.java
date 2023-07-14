package com.pruebaTecnica.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pruebaTecnica.entity.Document;
import com.pruebaTecnica.model.DocumentModel;
import com.pruebaTecnica.service.DocumentsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("documents")
public class DocumentsController {

	@Autowired
	DocumentsService documentsService;
	
	@PostMapping
	public void save(@Valid @RequestBody Document document) {
		documentsService.save(document);
	}
	
	@PutMapping
	public void update(@Valid @RequestBody DocumentModel document) {
		documentsService.updateFile(document);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		documentsService.deleteFile(id);
	}
	
	@PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public String upload(@RequestPart(value = "files") List<MultipartFile> files, @RequestParam(value="names") List<String> nombres){
		return documentsService.upload(files, nombres);
	}
}
