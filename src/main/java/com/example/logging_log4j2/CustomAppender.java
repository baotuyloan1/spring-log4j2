package com.example.logging_log4j2;

import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

@Plugin(name = "CustomAppender", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE)
public class CustomAppender extends AbstractAppender {
    protected CustomAppender(String name, Filter filter) {
        super(name, filter, null, false, null);
    }

    /**
     * createMyAppender method is responsible for creating the instance of our appender
     *
     * also used @Plugin and @PluginFactory annotations to tell Log4j how to create the appender itself.
     * @param name
     * @param filter
     * @return
     */
    @PluginFactory
    public static CustomAppender createMyAppender(@PluginAttribute("name")String name, @PluginElement("Filter") Filter filter){
        return new CustomAppender(name, filter);
    }

    @Override
    public void append(LogEvent event) {
        System.out.println("Hello this is append function my customer appender");
    }
}
