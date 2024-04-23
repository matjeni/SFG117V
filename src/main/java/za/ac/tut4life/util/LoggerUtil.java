package za.ac.tut4life.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
     Logger LOGGER = LoggerFactory.getLogger(LoggerUtil.class);
    public void info(String message){
         LOGGER.info(message);
    }
    public void error(String message,Throwable t){
        LOGGER.error(message,t);
    }

    public void info(String message,String arg,String args){
        LOGGER.info(message,arg,args);
    }

    public void info(String message,String arg){
        LOGGER.info(message,arg);
    }

}
