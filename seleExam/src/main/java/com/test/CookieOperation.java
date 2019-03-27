package com.test;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sunny on 2019-03-18.
 */
public class CookieOperation {
    @Test
    public void cookieOperationTest(){
        WebDriver driver = BaseChromeDriver.getChromeDriver();
        driver.get("http://www.baidu.com");
        driver.manage().window().maximize();

        // 获取所有cookie个数
        System.out.println(driver.manage().getCookies().size());

        // 增加cookie
        Cookie cookie = new Cookie("username", "name1", "/", null);
        driver.manage().addCookie(cookie);
        driver.manage().addCookie(new Cookie("password", "pppwwww", "/", null));
        System.out.println(driver.manage().getCookies().size());

        Set<Cookie> cookies = (HashSet<Cookie>) driver.manage().getCookies();
        for(Cookie co: cookies){
            System.out.print(co.getName().toString() + ": " + co.getValue());
            System.out.println(",  " + co.getDomain() + ",  " + co.getPath());
        }

        // 以name获取cookie
        String name = driver.manage().getCookieNamed("username").getValue();
        String info = "用户名是： " + name;
        String js = "alert(\"" + info + "\");";
        System.out.println(js);
        ((JavascriptExecutor) driver).executeScript(js);

        BaseWaitTime.waitTime(2000);
        driver.switchTo().alert().dismiss();

        // 以name删除cookie
        driver.manage().deleteCookieNamed("password");

        // 再次获取所有cookie个数
        System.out.println(driver.manage().getCookies().size());

        driver.quit();
    }
}
