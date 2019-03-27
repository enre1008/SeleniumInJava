package com.test;

import com.sun.xml.internal.rngom.parse.host.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by sunny on 2019-03-12.
 */
public class AlertHandle {
    @Test
    public void alertHandleTest(){
        WebDriver driver = BaseChromeDriver.getChromeDriver();
        driver.get("file:/Users/sunny/workspace/seleExam/src/main/resources/alert.html");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("[id=alertTest]")).click();

       try {
           //1. 先等待prompt框的出现，然后输入内容
           new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent()); //弹出一个警告框
           driver.switchTo().alert().sendKeys("111处理告警框的例子"); //向警告框里输入信息
           //BaseSnapshot.snapshot((TakesScreenshot) driver, BaseFileName.setFileName());

           //确认输入内容
           BaseWaitTime.waitTime(2000);
           driver.switchTo().alert().accept(); //在警告框里点击确定按钮

           //获取Alert框内text内容
           String inputInfo = driver.switchTo().alert().getText();
           System.out.println(inputInfo);

           //关闭Alert框,1结束
           BaseWaitTime.waitTime(2000);
           driver.switchTo().alert().accept();

           //2. 利用js构造一个confirm框
           BaseWaitTime.waitTime(2000);
           String js = "confirm(\"222这就是一个告警框的例子\")";
           ((JavascriptExecutor) driver).executeScript(js);
           //BaseSnapshot.snapshot((TakesScreenshot) driver, BaseFileName.setFileName());

           //取消confirm框，2结束
           BaseWaitTime.waitTime(2000);
           driver.switchTo().alert().dismiss(); //在警告框里点击取消按钮

           BaseWaitTime.waitTime(2000);
           driver.quit();
       }catch (TimeoutException e){
           driver.quit();
       }
    }
}
