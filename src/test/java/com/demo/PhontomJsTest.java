package com.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class PhontomJsTest {
    private WebDriver driver =null;
    @BeforeMethod
    public void set(){
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\SI\\Downloads\\si_demo1\\drivers\\chromedriver.exe");
        System.setProperty("phontomjs.binary.path","C:\\Users\\SI\\Downloads\\si_demo1\\drivers\\phantomjs.exe");
        //        实例化webdriver
        driver = new PhantomJSDriver();
    }
    @AfterTest
    public void close(){
        //        完全退出，关闭浏览器
        driver.quit();
    }
}
