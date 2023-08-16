package com.example.logging_log4j2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application will ask LogManager for a logger with a specific name
 * Logger will locate the appropriate LoggerContext and then obtain Logger from it
 * If the logger isn't created yet, it will be created and associated with LoggerConfig according to three choices below:
 * <p>
 * Logger instance will be created and associated with the LoggerConfig that have the same name.
 * For example App.class in getLogger(App.class) will be evaluated to be a String com.example.App
 * LoggerConfig name is identical(giống nhau) to fully qualified class name
 *
 * Logger instance will be created and associated with the LoggerConfig that have the same Loggers parent package.
 * For example com.journaldev in getLogger("com.journaldev")
 *
 * Logger instance will be created and associated with the Root LoggerConfig.
 * Root LoggerConfig will be used when there is no configuration file or when you’re obtaining a logger with name not defined in the logger declarations.
 *
 * LoggerConfig objects are created from Logger declaration in the configuration file.
 *
 * LoggerConfig is also used to handle LogEvents and delegate (giao phó) them for their defined Log4j2 Appenders.
 *
 * Root logger always exists and at the top of any logger hierarchy.
 *
 * Obtain the root logger by using statements:
 * Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
 * Logger logger = LogManager.getRootLogger();
 */
@SpringBootApplication
public class LoggingLog4j2Application {

    public static void main(String[] args) {
        SpringApplication.run(LoggingLog4j2Application.class, args);
    }

}
