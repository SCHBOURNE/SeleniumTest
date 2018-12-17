package com.demo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class FindElementTest {
//    System.setProperty("webdriver.chrome.driver","C:\\Users\\SI\\Downloads\\si_demo1\\drivers\\chromedriver.exe");
    private WebDriver driver;
    @Test
    public void find(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SI\\Downloads\\si_demo1\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        WebElement newlink = driver.findElement(By.xpath("//*[@id=\"u1\"]/a[1]"));
        newlink.click();
        String url = driver.getCurrentUrl();
//        Assert.assertEquals(url,"http://news.baidu.com/");
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("C:\\Users\\SI\\Desktop\\test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void comfirmTest(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SI\\Downloads\\si_demo1\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("E:/BaiduNetdiskDownload/selenium+java%E8%87%AA%E5%8A%A8%E5%8C%96%EF%BC%88%E6%9C%80%E6%96%B0%EF%BC%89(1)/%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='confirm']/input")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Alert alert = driver.switchTo().alert();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        alert.dismiss();

    }
    @Test
    public void testIframe(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SI\\Downloads\\si_demo1\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("E:/BaiduNetdiskDownload/selenium+java%E8%87%AA%E5%8A%A8%E5%8C%96%EF%BC%88%E6%9C%80%E6%96%B0%EF%BC%89(1)/" +
                "%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.manage().window().maximize();
        WebElement frame = driver.findElement(By.name("aa"));
        driver.switchTo().frame(frame);
        driver.findElement(By.linkText("baidu")).click();
    }
    @Test
    public void testSelect(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SI\\Downloads\\si_demo1\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("E:/BaiduNetdiskDownload/selenium+java%E8%87%AA%E5%8A%A8%E5%8C%96%EF%BC%88%E6%9C%80%E6%96%B0%EF%BC%89(1)/" +
                "%E6%BA%90%E7%A0%81/webdriver_demo/selenium_html/index.html");
        driver.manage().window().maximize();
        WebElement selectEL = driver.findElement(By.id("moreSelect"));
        Select select = new Select(selectEL);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("moreSelect")));
        select.selectByVisibleText("vivo");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        select.selectByValue("iphone");

    }
    @AfterMethod
//    彻底退出浏览器
    public void closeChrome(){
       driver.quit();
    }
}
