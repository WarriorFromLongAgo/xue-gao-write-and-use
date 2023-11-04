package com.xuegao.springcloudstarteroauth2demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringCloudStarterOauth2DemoApplicationTests {

	@Test
	void contextLoads() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encode = bCryptPasswordEncoder.encode("crm-123456");
		System.out.println(encode);

		// $2a$10$cFAXjKVyYfi9dhFm90Row.pZdgwzHCB1I06ThERyOFp6FpO932Qci
	}

}
