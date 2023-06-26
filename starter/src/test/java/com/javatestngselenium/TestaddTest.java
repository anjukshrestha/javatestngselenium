package com.javatestngselenium;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestaddTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public  void setUp() {
    ChromeOptions options = new ChromeOptions().setHeadless(true);
    driver = new ChromeDriver(options);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testadd() {
    driver.get("https://anjukshrestha.github.io/");
    driver.manage().window().setSize(new Dimension(1920, 996));
    driver.findElement(By.id("taskInput")).click();
    driver.findElement(By.id("taskInput")).sendKeys("test");
    driver.findElement(By.id("addButton")).click();
    String text = driver.findElement(By.xpath("//*[@id=\"taskList\"]/li/span")).getText();
            
    Assert.assertEquals("test", text); 
  }
}
