package za.ac.tut4life.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    public void LOG_INFO(String message,Class c){
         final Logger LOGGER = LoggerFactory.getLogger(c.getName());
         LOGGER.info(message);
    }
}
