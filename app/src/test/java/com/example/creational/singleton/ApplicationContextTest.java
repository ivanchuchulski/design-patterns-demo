package com.example.creational.singleton;

import com.example.creational.singleton.ApplicationContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextTest {
    @Test
    void test() {
        ApplicationContext.Config initialConfig = new ApplicationContext.Config("title 1", false);

        ApplicationContext applicationContext = ApplicationContext.getInstance(initialConfig);

        assertEquals(initialConfig, applicationContext.getConfig());

        ApplicationContext.Config secondConfig = new ApplicationContext.Config("title 2", true);
        ApplicationContext applicationContextAgain = ApplicationContext.getInstance(initialConfig);

        applicationContextAgain.setConfig(secondConfig);

        assertEquals(secondConfig, applicationContext.getConfig());
        assertEquals(secondConfig, applicationContextAgain.getConfig());
    }
}