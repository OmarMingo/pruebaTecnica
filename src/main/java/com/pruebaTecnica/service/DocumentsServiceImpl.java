package com.pruebaTecnica.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.pruebaTecnica.configuration.FileConfiguration;
import com.pruebaTecnica.entity.Document;
import com.pruebaTecnica.model.DocumentModel;
import com.pruebaTecnica.repository.DocumentsRepository;

@Service
public class DocumentsServiceImpl implements DocumentsService{

	@Autowired
	DocumentsRepository documentsRepository;
	
	private final Path fileStorageLocation;
	
	@Autowired
    public DocumentsServiceImpl(FileConfiguration fileConfiguration) {
        this.fileStorageLocation = Paths.get(fileConfiguration.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }
	
	@Override
	public void save(Document documento) {
		documento.setPath(documento.getName());
		documentsRepository.save(documento);
	}

	@Override
	public void updateFile(DocumentModel documentoModel) {
		Document doc = new Document();
		doc.setName(documentoModel.getName());
		doc.setPath(storeFile(documentoModel.getFile(), documentoModel.getName()));
		documentsRepository.save(doc);		
	}

	@Override
	public String storeFile(MultipartFile documento, String nombre) {
		String fileName = StringUtils.cleanPath(documento.getOriginalFilename());
        String extension = fileName.substring(fileName.lastIndexOf("."));
        String newName = nombre + extension;
        try {
            Path targetLocation = this.fileStorageLocation.resolve(newName);
            Files.copy(documento.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return newName;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
	}
	
	@Override
	public String upload(List<MultipartFile> documentos, List<String> nombres) {
		if(this.validaNombre(nombres)) {
			return "Uno o varios archivos de los nombres ya existen";
		}else {
			if(documentos.size() != nombres.size()) {
				return "El numero de documentos no es igual al numero de nombres";
			}else {
				for (int i = 0; i < documentos.size(); i++) {
		            storeFile(documentos.get(i), nombres.get(i));
		        }
				return "Guardado correctamente";
			}			
		}
	}

	@Override
	public void deleteFile(Long id) {
		Optional<Document> verify = documentsRepository.findById(id);
        if(verify.isPresent()){
            Path file = Paths.get("./upload/"+verify.get().getPath());
            try {
                Files.delete(file);
            }catch (Exception e){
                
            }
            documentsRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se encontro el documento con id " + id );
        }
	}
	
	private Boolean validaNombre(List<String> nombres) {
		List<Document> d = documentsRepository.findByNombreIn(nombres);
        return d.size() > 0;
	}
}
