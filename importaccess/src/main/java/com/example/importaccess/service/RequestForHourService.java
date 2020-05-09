package com.example.importaccess.service;

import java.util.List;

import com.example.importaccess.model.RequestForHour;
import com.example.importaccess.repository.RequestForHourRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestForHourService {

    @Autowired
    private RequestForHourRepository repository;

    public List<RequestForHour> countRequestForHours() {
        return this.repository.countRequestForHour();
    }
    
}