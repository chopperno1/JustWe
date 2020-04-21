package com.JustWe;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JustWeApplicationTests {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	void contextLoads() {

		logger.trace("trace测试测试");
		logger.debug("debug测试测试");
		logger.info("info测试测试");
		logger.warn("warn测试测试");
		logger.error("error测试测试");

	}

}
