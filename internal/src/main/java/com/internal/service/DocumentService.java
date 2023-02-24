package com.internal.service;

import java.util.List;

import com.internal.entity.Document;
import com.internal.exception.CustomException;


public interface DocumentService {

	/*
	 * *************************************************************************
	 * create operations
	 * ***********************************************************************
	 */
	public Document createDocument(Document document) throws CustomException;
/*
	 * *************************************************************************
	 * read operations
	 * ***********************************************************************
	 */
	public Document readDocumentById(int id) throws CustomException;
	public Document readDocumentTitle(String documentTitle) throws CustomException;
	public  List<Document>  readAllDocuments() throws CustomException;
	/*
	 * *************************************************************************
	 * update operations
	 * ***********************************************************************
	 */

	public Document updateDocument(Document document) throws CustomException; // update
	
	
	/*
	 * *************************************************************************
	 * delete operations
	 * ***********************************************************************
	 */
	public String deleteById(int id) throws CustomException;
	
}
