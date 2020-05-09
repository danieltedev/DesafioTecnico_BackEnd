package com.example.importaccess.resource;

import java.util.List;

import com.example.importaccess.model.RequestForIp;
import com.example.importaccess.service.RequestForIpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request-for-ip")
public class RequestForIpResource {

    @Autowired
    private RequestForIpService service;

    @GetMapping
    public List<RequestForIp> countRequestForIp() {
        return this.service.countRequestForIp();
    }
}