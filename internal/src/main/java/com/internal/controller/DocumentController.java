package com.internal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internal.entity.Document;
import com.internal.service.DocumentService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/document")
public class DocumentController {

		@Autowired
		DocumentService documentService;
	/*
	 * *************************************************************************
	 *  create operations
	 * ***********************************************************************
	 */
	
	@PostMapping(value = "/createDocument")
	public ResponseEntity<Document> createUser(@Valid @RequestBody Document document) {

		return new ResponseEntity<Document>(documentService.createDocument(document), HttpStatus.ACCEPTED);

	}

	/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */

	@GetMapping(value = "/getDocumentById/{documentId}")
	public ResponseEntity<Document> getDocumentById(@Valid @PathVariable("documentId") int documentId) {
		return new ResponseEntity<Document>(documentService.readDocumentById(documentId), HttpStatus.OK);
	}
	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */

	

	@DeleteMapping(value = "/deleteDocument/{documentId}/{userPassword}")
	public ResponseEntity<String> deleteDocument(@Valid @PathVariable("documentId") int documentId) {
		return new ResponseEntity<String>(documentService.deleteById(documentId), HttpStatus.OK);
	}
	

	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */


	@PutMapping(value = "/updateDocument/{document}")
	public  ResponseEntity<Document> updateUser(@Valid @RequestBody Document document) {
		return new ResponseEntity<Document>(documentService.updateDocument(document), HttpStatus.ACCEPTED);

	}
}
