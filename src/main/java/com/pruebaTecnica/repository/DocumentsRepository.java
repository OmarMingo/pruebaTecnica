package com.pruebaTecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebaTecnica.entity.Document;

@Repository
public interface DocumentsRepository extends JpaRepository<Document, Long>{

	List<Document> findByNombreIn(List<String> nombres);

}
