package com.demo;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenBrowserTest {
//    @Test
//    public void openFF(){
//        WebDriver webDriver = new FirefoxDriver();
//    }
    private WebDriver driver =null;

    @BeforeMethod
    public void set(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SI\\Downloads\\si_demo1\\drivers\\chromedriver.exe");
        //        实例化webdriver
        driver = new ChromeDriver();
    }
    @Test
    public void openChrome(){

//        设置窗口大小
        Dimension dimension = new Dimension(500,500);
        driver.manage().window().setSize(dimension);
//        最大化
        driver.manage().window().maximize();
        driver.get("http://baidu.com");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
//        driver.get("https://www.qq.com/");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        后退
//        driver.navigate().back();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.navigate().forward();
//        driver.navigate().refresh();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("http://baidu.com");
//        关闭当前窗口
        driver.close();
//        完全退出，关闭浏览器
        driver.quit();
    }
    @AfterMethod
    public void close(){
        //        完全退出，关闭浏览器
        driver.quit();
    }
}
