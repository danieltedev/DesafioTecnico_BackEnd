package com.example.importaccess.resource;

import java.util.List;

import com.example.importaccess.model.RequestForUserAgent;
import com.example.importaccess.service.RequestForUserAgentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request-for-user-agent")
public class RequestForUserAgentResource {
    
    @Autowired
    private RequestForUserAgentService service;

    @GetMapping
    public List<RequestForUserAgent> countRequestForUserAgent() {
        return this.service.countRequestForUserAgent();
    }

}