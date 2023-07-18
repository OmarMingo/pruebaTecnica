package com.pruebaTecnica.soap.endpoint;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.pruebaTecnica.entity.Document;
import com.pruebaTecnica.model.DocumentModel;
import com.pruebaTecnica.rest.controller.DocumentsController;
import com.pruebaTecnica.service.DocumentsService;


@WebService(endpointInterface = "com.pruebaTecnica.prueba.DocumentsService", serviceName = "DocumentsService")
public class DocumentsEndpoint implements DocumentsService{

	@Autowired
	DocumentsController documentsController;
	
	@Resource
	WebServiceContext wsContext;
	
	@Override
	public void save(Document documento) {
		documentsController.save(documento);
	}

	@Override
	public void updateFile(DocumentModel documentoModel) {
		documentsController.update(documentoModel);
	}

	@Override
	public String upload(List<MultipartFile> files, List<String> nombres) {
		return documentsController.upload(files, nombres);
	}

	@Override
	public void deleteFile(Long id) {
		documentsController.delete(id);
	}

}
