package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.Properties;

public class BaseChromeDriver {
    public static WebDriver getChromeDriver(){
        String chromeDriverPlace = null;
        Properties properties = new Properties();
        InputStream inputStream = null;

        try {
            File file = new File("/Users/sunny/workspace/seleExam/src/main/config/config.properties");
            inputStream = new BufferedInputStream(new FileInputStream(file));
            properties.load(inputStream);
            chromeDriverPlace = properties.getProperty("chromeDriverPlace");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", chromeDriverPlace);
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
