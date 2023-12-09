package com.aweit.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 參考文檔：https://www.docs4dev.com/docs/zh/log4j2/2.x/all/manual-index.html
 * 1. dependency: log4j-api (2.7)、log4j-core(2.7)、log4j-slf4j-impl(2.7)、jackson-databind(2.15.2)
 * 2. log4j2.xml: 放在 resources 資料夾。並且寫 Log 的處理方式。
 * 3. Level：debug、info、warn、error
 */
public class Slf4JDemo {

	private static Logger logger = LoggerFactory.getLogger(Slf4JDemo.class);

	public static void main(String[] args) {

		logger.debug("Debug log message");
		logger.info("Info log message");
		logger.error("Error log message");

	}

}
