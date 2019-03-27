package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by sunny on 2019-03-08.
 */
public class CheckBox {
    private Object TakesScreenshot;

    @Test
    public void checkBoxTest(){
        WebDriver driver = BaseChromeDriver.getChromeDriver();
        driver.get("file:/Users/sunny/workspace/seleExam/src/main/resources/checkbox.html");
        driver.manage().window().maximize();

        List<WebElement> webElements = driver.findElements(By.cssSelector("[type=checkbox]"));
        Iterator iterator = webElements.iterator();

        //全部勾选
        while(iterator.hasNext()){
            WebElement wb = (WebElement) iterator.next();
            wb.click();
        }
        BaseSnapshot.snapshot((TakesScreenshot) driver, BaseFileName.setFileName());

        //去掉第一个
        BaseWaitTime.waitTime(2000);
        driver.findElements(By.cssSelector("[type=checkbox]")).get(0).click();
        BaseSnapshot.snapshot((TakesScreenshot) driver, BaseFileName.setFileName());

        //去掉最后一个
        BaseWaitTime.waitTime(2000);
        driver.findElements(By.cssSelector("[type=checkbox]")).get(webElements.size()-1).click();
        BaseSnapshot.snapshot((TakesScreenshot) driver, BaseFileName.setFileName());

        driver.quit();
    }
}
