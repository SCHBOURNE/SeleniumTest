package com.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestNgDemoTest {
    @Test
    public void assertTest(){
        String a ="123";
        String b ="234";
        Assert.assertEquals(a,b);

    }
}