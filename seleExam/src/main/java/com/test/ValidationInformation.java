package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.*;

public class ValidationInformation {
    @Test
    public void getValidatInformation(){
        WebDriver driver = BaseChromeDriver.getChromeDriver();
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();

        File file = new File("src/test/result.txt");
        DataOutputStream dos = null;
        if(!file.exists()){
            try {

                file.createNewFile();
                file.setWritable(true);
                //Runtime.getRuntime().exec("chmod 777 fi")

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                dos = new DataOutputStream(new FileOutputStream(file, true));
                dos.write(("\ngetCurrentUrl: "+driver.getCurrentUrl()+"\n").getBytes());
                dos.write(("getTitle: "+driver.getTitle()+"\n").getBytes());
                dos.write(("getWindowHandle: "+driver.getWindowHandle()+"\n").getBytes());
                dos.write(("hashCode: "+driver.hashCode()+"\n").getBytes());

                dos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        driver.quit();
    }
}
