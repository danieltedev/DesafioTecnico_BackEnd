package com.example.importaccess.repository;

import com.example.importaccess.model.Access;
import com.example.importaccess.model.AccessId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends JpaRepository<Access, AccessId>, JpaSpecificationExecutor<Access> {
    
}