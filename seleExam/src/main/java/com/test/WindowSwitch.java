package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sunny on 2019-03-12.
 */
public class WindowSwitch {
    @Test
    public void windowSwitchTest(){
        WebDriver driver = BaseChromeDriver.getChromeDriver();
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();

        String searchHandle = driver.getWindowHandle();
        System.out.println("baidu search handle: " + searchHandle);

        //获取百度新闻的连接，然后利用js打开一个新的窗口
        BaseWaitTime.waitTime(2000);
        String href = driver.findElement(By.cssSelector("[name=tj_trnews]")).getAttribute("href");
        System.out.println("the link of news is; " + href);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('" + href + "')");
        BaseSnapshot.snapshot((TakesScreenshot) driver, BaseFileName.setFileName());

        BaseWaitTime.waitTime(2000);
        Set<String> handles = driver.getWindowHandles();
        Iterator iterator = handles.iterator();
        Iterator iterator2 = handles.iterator();

        //进入百度新闻窗口，并获取title验证
        BaseWaitTime.waitTime(2000);
        while(iterator.hasNext()){
            String h = (String)iterator.next();
            if(h != searchHandle){
                driver.switchTo().window(h);
                if(driver.getTitle().contains("百度新闻")){
                    System.out.println("switch to news page successfully!!");
                    BaseSnapshot.snapshot((TakesScreenshot) driver, BaseFileName.setFileName());
                    break;
                }else{
                    continue;
                }
            }
        }
        while (iterator2.hasNext()){
            String h = (String)iterator2.next();
            if(searchHandle.equals(h)){
                driver.switchTo().window(h);
                if(driver.getTitle().contains("百度一下")){
                    System.out.println("switch to search page successfully!!");
                    BaseSnapshot.snapshot((TakesScreenshot) driver, BaseFileName.setFileName());
                    driver.findElement(By.cssSelector("#kw")).sendKeys("switch successfully");
                    BaseSnapshot.snapshot((TakesScreenshot) driver, BaseFileName.setFileName());
                    break;
                }else{
                    continue;
                }
            }
        }
        driver.quit();
    }
}
