package com.example.creational.singleton;

public class ApplicationContext {
    private static ApplicationContext instance;

    private Config config;

    private ApplicationContext(Config config) {
        this.config = config;
    }

    public static ApplicationContext getInstance(Config config) {
        if (instance == null) {
            instance = new ApplicationContext(config);
        }

        return instance;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public record Config(String title, boolean property) {
    }
}
