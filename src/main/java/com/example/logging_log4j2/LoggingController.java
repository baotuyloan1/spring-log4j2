package com.example.logging_log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoggingController {

    /**
     * in the majority of the cases it will be a private, static object inside a class.
     * <p>
     * create the logger object
     */
    private static final Logger LOGGER = LogManager.getLogger(LoggingController.class);


    @GetMapping("/")
    public String showForm(Model model) {
        Account account = new Account();
        model.addAttribute(account);
        LOGGER.error("This runtime exception");
        LOGGER.warn("Hello waring");
        if (true)
            throw new RuntimeException("This runtime exception");

        return "welcome";
    }

    @PostMapping("/")
    public String formSubmit(@ModelAttribute Account account) {
        /**
         * no matter which method of initialization we will choose, once we have the logger instance
         * we can use it to generate our log events.
         *
         * A log level or log severity is a piece of information telling how important a given log is.
         */
        LOGGER.info("info console"); //log event
        LOGGER.error("error file");
        LOGGER.warn("Waring file");
        if (account.getUsername().isEmpty() || account.getUsername() == null) {
            return "redirect:/";
        }
        return "greeting";
    }


}
