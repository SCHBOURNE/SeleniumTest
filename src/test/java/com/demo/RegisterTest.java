package com.demo;

import com.gargoylesoftware.htmlunit.html.HtmlListing;
import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.css.sac.ElementSelector;

import java.sql.Driver;

public class RegisterTest {
    private WebDriver driver = null;
    @BeforeMethod
    public void set(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SI\\Downloads\\si_demo1\\drivers\\chromedriver.exe");
//        System.setProperty("phontomjs.binary.path","C:\\Users\\SI\\Downloads\\si_demo1\\drivers\\phantomjs.exe");
        //        实例化webdriver
        driver = new ChromeDriver();
//        driver = new PhantomJSDriver();
    }
    @AfterTest
    public void close(){
        //        完全退出，关闭浏览器
        driver.quit();
    }
    @Test
    public void regist() throws InterruptedException {
        driver.get("https://mail.163.com/");
        driver.manage().window().maximize();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,\"x-URS-iframe1\")]")));//
        // driver.switchTo().frame("x-URS-iframe");
 //       driver.findElement(By.xpath("//*[@id=\"changepage\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"changepage\"]")));
        Thread.sleep(3000);
        String handle1 = driver.getWindowHandle();
        for(String handle:driver.getWindowHandles()){
            if(handle.equals(handle1))
                    continue;
            else
                driver.switchTo().window(handle);

        }
        long time = System.currentTimeMillis();
    }
}
