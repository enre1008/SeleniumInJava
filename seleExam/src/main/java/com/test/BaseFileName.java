package com.test;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BaseFileName {

    public static String setFileName(){
        //long FileName = System.currentTimeMillis();
        Properties properties = new Properties();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SSS");
        String fileName = df.format(new Date());
        String fileDir = null;

        File file = new File("/Users/sunny/workspace/seleExam/src/main/config/config.properties");
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
            properties.load(inputStream);
            fileDir = properties.getProperty("fileDir");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String fileFullName = (fileDir + "screenshot_" + fileName + ".png");
        return fileFullName;

    }
}
