package com.JustWe;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class JustWeApplicationTests {

	Logger logger = LoggerFactory.getLogger(getClass());


	@Autowired
	DataSource dataSource;


	@Test
	void contextLoads() throws SQLException {
		logger.trace("trace测试测试");
		logger.debug("debug测试测试");
		logger.info("info测试测试");
		logger.warn("warn测试测试");
		logger.error("error测试测试");

		logger.info("数据连接:" + dataSource.getClass());
		Connection connection = dataSource.getConnection();

		logger.info("数据连接:" + connection);
		connection.close();

	}

}
