package com.example.importaccess.resource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@TestPropertySource("classpath:application.properties")
public class LogResourceTest {

    @Test
	void sendFile() throws FileNotFoundException {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		File file = new File(getClass().getClassLoader().getResource("static/user_agent.log").getFile());
		FileSystemResource fileResource = new FileSystemResource(file);

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("file", fileResource);

		String url = "http://localhost:8080/access";

		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

		assertNotNull(response);
	}
    
}