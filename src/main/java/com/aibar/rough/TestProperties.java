package com.aibar.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) {

        Properties config = new Properties();
        Properties objectRepository = new Properties();

        try {
            config.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\Config.properties"));
            objectRepository.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\ObjectRepository.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(config.getProperty("browser"));
        System.out.println(objectRepository.getProperty("BankManagerLogin"));
    }
}
