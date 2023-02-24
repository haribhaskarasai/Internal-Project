package com.internal.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.entity.Document;
import com.internal.exception.CustomException;
import com.internal.repository.DocumentRepository;
import com.internal.service.DocumentService;

@Service
@Transactional 
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	DocumentRepository documentRepository;
	
	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */
	public Document createDocument(Document document) throws CustomException{
		if(documentRepository.existsById(document.getId())){
			throw new CustomException("Document already exits");
		}
		
		return documentRepository.save(document);
	}
     /*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */
	public Document readDocumentById(int id) throws CustomException{
		if(documentRepository.existsById(id)){
			return documentRepository.findById(id).get();
		}
		else {
			throw new CustomException("Document does not exits");

		}
	}
	public Document readDocumentTitle(String documentTitle) throws CustomException{
		return null;
	}
	public List<Document> readAllDocuments() throws CustomException{
		if(documentRepository.findAll().isEmpty()){
			throw new CustomException("There are no documents exits");
		}
		else {
			return documentRepository.findAll();

		}
	}
	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */

	public Document updateDocument(Document document) throws CustomException{
		if(documentRepository.existsById(document.getId())){
			return documentRepository.save(document);
		}
		else {
			throw new CustomException("Document does not exits");

		}
	}
	
	
	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */
	public String deleteById(int id) throws CustomException{
		if(documentRepository.existsById(id)){
			 documentRepository.deleteById(id);
			 return "document with " + id +" deleted";
					 
			 
		}
		else {
			throw new CustomException("Document does not exits");

		}
	}
	
}
