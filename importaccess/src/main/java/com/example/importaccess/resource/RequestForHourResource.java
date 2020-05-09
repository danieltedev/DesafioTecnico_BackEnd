package com.example.importaccess.resource;

import java.util.List;

import com.example.importaccess.model.RequestForHour;
import com.example.importaccess.service.RequestForHourService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request-for-hour")
public class RequestForHourResource {

    @Autowired
    private RequestForHourService service;

    @GetMapping
    public List<RequestForHour> countRequestForHours() {
        return this.service.countRequestForHours();
    }
    
}