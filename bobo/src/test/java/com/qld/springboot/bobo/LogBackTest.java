package com.qld.springboot.bobo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: bobo
 * @description:
 * @author: 秦令达
 * @create: 2019-07-01 16:44
 */
public class LogBackTest {
    private Logger logger = LoggerFactory.getLogger(LogBackTest.class);

    @Test
    public void getLog() {
        for (int i = 0; i < 50; i++) {
            logger.trace("1");
            logger.debug("2");
            logger.info("3");
            logger.warn("4");
            logger.error("5");
        }
    }

}
