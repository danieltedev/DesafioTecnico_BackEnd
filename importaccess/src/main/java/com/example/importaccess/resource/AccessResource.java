package com.example.importaccess.resource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.importaccess.model.Access;
import com.example.importaccess.model.filter.AccessFilter;
import com.example.importaccess.service.AccessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/access")
public class AccessResource {

    @Autowired
    private AccessService accessService;

    @GetMapping
    public Page<Access> filter(AccessFilter filter, Pageable pageable) {
        return this.accessService.filter(filter, pageable);
    }

    @GetMapping("/teste")
    public void teste(@RequestParam String date) {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS");
        LocalDateTime localDate = dateTimeFormat.parse(date, LocalDateTime::from);
        System.out.println(localDate);
    }

    @PostMapping
    public void uploadFile(@RequestParam MultipartFile file) {
        this.accessService.uploadFile(file);
    }
}