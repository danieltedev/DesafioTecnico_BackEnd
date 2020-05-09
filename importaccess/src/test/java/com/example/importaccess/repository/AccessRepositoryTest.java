package com.example.importaccess.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.example.importaccess.model.Access;
import com.example.importaccess.model.filter.AccessFilter;
import com.example.importaccess.repository.specification.AccessSpec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource("classpath:application.properties")
public class AccessRepositoryTest {

    @Autowired
    private AccessRepository accessRepository;

    @Test
	void getAll() {
		final List<Access> findAll = this.accessRepository.findAll();

		assertNotNull(findAll);
	}

	@Test
	void create() {
		LocalDateTime data = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		Access access = new Access("10.10.10.10", data, "\"TESTE\"", "\"CHROME\"", 1);

		Access newLog = this.accessRepository.save(access);

		assertEquals(newLog.toString(), access.toString());
	}

	@Test
	void findOneByIp() {
		LocalDateTime data = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		Access access = new Access("192.168.0.0", data, "\"TESTE\"", "\"CHROME\"", 1);
		AccessFilter filter = new AccessFilter("192.168.0.0");

		this.accessRepository.save(access);

		Access foundAccess = this.accessRepository.findAll(new AccessSpec(filter).build()).stream().reduce((first, last) -> last).orElse(null);

		assertEquals(foundAccess.toString(), access.toString());
	}
    
}