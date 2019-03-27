package com.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class BaseSnapshot {
    public static void snapshot(TakesScreenshot drivername, String filename){

        File srcFile = drivername.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
