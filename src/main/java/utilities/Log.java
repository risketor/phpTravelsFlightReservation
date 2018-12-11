package utilities;

import org.apache.log4j.Logger;
import org.junit.Assert;

/**
 * @author - Alberto Bartolome Sanchez on 09.12.2018.
 * @project phpTravelsFlightReservation
 * Log layer, to manage logger and assertions
 */
public class Log {

    final static Logger logger = Logger.getLogger(Log.class);

    public static void info(String info_message) {
        if (logger.isInfoEnabled()) {
            logger.info(info_message);
        }
    }

    public static void debug(String info_message) {
        if (logger.isDebugEnabled()) {
            logger.debug(info_message);
        }
    }

    public static void warn(String info_message) {
        logger.warn(info_message);
    }

    public static void error(String info_message) {
        logger.error(info_message);
    }

    public static void fatal(String info_message) {
        logger.fatal(info_message);
    }

    /**
     * Assert condition, send message to logs
     * @param s
     * @param equals
     */
    public static void assertTrue(String s, boolean equals) {
        if(!equals){
            Log.error("Assertion Failed - " + s);
            Assert.fail(s);
        }else{
            Log.info("Assertion OK - " + s);
        }
    }

    /**
     * Through exception with message
     * @param message
     */
    public static void exception(String message) {
            Log.error("Exception: " + message);
            Assert.fail(message);
    }
}
