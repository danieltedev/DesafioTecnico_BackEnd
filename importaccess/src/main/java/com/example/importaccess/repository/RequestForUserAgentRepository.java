package com.example.importaccess.repository;

import com.example.importaccess.model.Access;
import com.example.importaccess.model.AccessId;
import com.example.importaccess.repository.custom.RequestForUserAgentRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestForUserAgentRepository  extends JpaRepository<Access, AccessId>, JpaSpecificationExecutor<Access>, RequestForUserAgentRepositoryCustom {
    
}