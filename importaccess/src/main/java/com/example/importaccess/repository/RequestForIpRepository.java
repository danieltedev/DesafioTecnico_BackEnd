package com.example.importaccess.repository;

import com.example.importaccess.model.Access;
import com.example.importaccess.model.AccessId;
import com.example.importaccess.repository.custom.RequestForIpRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestForIpRepository extends JpaRepository<Access, AccessId>, JpaSpecificationExecutor<Access>, RequestForIpRepositoryCustom {
    
}