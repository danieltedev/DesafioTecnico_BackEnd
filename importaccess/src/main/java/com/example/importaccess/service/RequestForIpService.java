package com.example.importaccess.service;

import java.util.List;

import com.example.importaccess.model.RequestForIp;
import com.example.importaccess.repository.RequestForIpRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestForIpService {

    @Autowired
    private RequestForIpRepository repository;

    public List<RequestForIp> countRequestForIp() {
        return this.repository.countRequestForIp();
    }
    
}