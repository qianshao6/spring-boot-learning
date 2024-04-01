package top.jiejie.log.test;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LogTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args){
//        LDGGER.trace("Trace 日志...");
//        LDGGER.debug("Debug 日志...");
//        LDGGER.info("Info 日志...");
//        LDGGER.warn("Warn 日志...");
//        LDGGER.error("Error 日志...");
    Logger myLogger = LoggerFactory.getLogger("MyLogger");
    myLogger.info("hello world");
    }



}
