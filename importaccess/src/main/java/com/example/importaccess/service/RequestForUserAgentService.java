package com.example.importaccess.service;

import java.util.List;

import com.example.importaccess.model.RequestForUserAgent;
import com.example.importaccess.repository.RequestForUserAgentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestForUserAgentService {

    @Autowired
    private RequestForUserAgentRepository repository;

    public List<RequestForUserAgent> countRequestForUserAgent() {
        return this.repository.countRequestForUserAgent();
    }
    
}