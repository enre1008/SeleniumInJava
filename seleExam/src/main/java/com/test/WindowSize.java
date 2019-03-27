package com.test;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class WindowSize {
    @Test
    public void changeWindowSize()  {
        String URL = "http://www.baidu.com";

        WebDriver driver = null;
        driver = BaseChromeDriver.getChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        //new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("百度一下，你就知道"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BaseSnapshot.snapshot((TakesScreenshot) driver, BaseFileName.setFileName());

        Dimension arg0 = new Dimension(800,400);
        driver.manage().window().setSize(arg0);
        BaseSnapshot.snapshot((TakesScreenshot)driver, BaseFileName.setFileName());

        driver.quit();

    }
}
