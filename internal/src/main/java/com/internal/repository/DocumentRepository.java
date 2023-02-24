package com.internal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internal.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
