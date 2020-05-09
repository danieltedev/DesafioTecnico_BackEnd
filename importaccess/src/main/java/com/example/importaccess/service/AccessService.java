package com.example.importaccess.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.example.importaccess.model.Access;
import com.example.importaccess.model.filter.AccessFilter;
import com.example.importaccess.repository.AccessRepository;
import com.example.importaccess.repository.specification.AccessSpec;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AccessService {

    @Autowired
    private AccessRepository accessRepository;

    public Page<Access> filter(AccessFilter filter, Pageable pageable) {
        return this.accessRepository.findAll(new AccessSpec(filter).build(), pageable);
    }

    public void uploadFile(MultipartFile file) {
        String contentFile = null;
        try {
            contentFile = this.getContentFile(file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Access> listAccess = contentFile == null ? new ArrayList<>() : this.convertContentFileToAccess(contentFile);
        this.accessRepository.saveAll(listAccess);
    }

    private List<Access> convertContentFileToAccess(String stringAccess) {
        return Arrays.asList(stringAccess.split("\\n")).stream()
            .map(s -> convertStringToAccess(s))
            .collect(Collectors.toList());
    }

    private String getContentFile(InputStream inputStream) {
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    private Access convertStringToAccess(String line) {
        String[] args = line.split("\\|");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = null;
        try {
            date = formatter.parse(args[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LocalDateTime data = date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        Integer status = args[3] == null && args[3].equals("") ? null : Integer.valueOf(args[3]);
        return new Access(args[1], data, args[2], args[4], status);
    }
}