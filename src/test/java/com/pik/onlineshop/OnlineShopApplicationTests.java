package com.pik.onlineshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineShopApplicationTests {

	@Test
	@DisplayName("If 1 equals 1")
	void contextLoads() {
		Assertions.assertEquals(1, 1);
	}

}
