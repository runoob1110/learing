package com.jullog;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/10/10 9:31
 */
public class Test01 {
    private static final Logger logger = Logger.getLogger("Test01");
    public static void main(String[] args) {
        logger.setLevel(Level.SEVERE);

        logger.finest("finest");
        logger.finer("finer");
        logger.fine("fine");
        logger.config("config");
        logger.info("info");
        logger.warning("warning");
        logger.severe("severe");

    }
}
