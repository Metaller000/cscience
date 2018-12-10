package ru.metaller.cscience;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    void logFileCreatingTest(){
        logger.info("info");
        logger.debug("debug");
        logger.warn("warn");
        logger.error("error");
    }
}
