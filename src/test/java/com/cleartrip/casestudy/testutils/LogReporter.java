package com.cleartrip.casestudy.testutils;

import com.relevantcodes.extentreports.LogStatus;
import com.cleartrip.casestudy.TestBase;
import org.apache.log4j.Logger;

import static org.apache.log4j.Logger.getLogger;

/**
 * Log Reporter class
 */
public class LogReporter {

    /**
     * Logger Instance
     */
    private Logger logger;

    /**
     * Instantiates a new Log reporter.
     *
     * @param clazz the clazz
     */
    public LogReporter(final Class clazz) {
        logger = getLogger(clazz);
    }

    /**
     * Method that logs info LOGS
     *
     * @param message the message
     */
    public void info(final String message) {
        logger.info(message);
        if (TestBase.test != null) {
            TestBase.test.log(LogStatus.INFO, message);
        }
    }

    /**
     * Method that logs debug LOGS
     *
     * @param message the message
     */
    public void debug(final String message) {
        logger.debug(message);
    }

    /**
     * Method that logs warning LOGS
     *
     * @param message the message
     */
    public void warn(final String message) {
        logger.warn(message);
        if (TestBase.test != null) {
            TestBase.test.log(LogStatus.WARNING, message);
        }
    }

    /**
     * Method that logs error LOGS
     *
     * @param message the message
     */
    public void error(final String message) {
        logger.error(message);
        if (TestBase.test != null) {
            TestBase.test.log(LogStatus.ERROR, message);
        }
    }
}
