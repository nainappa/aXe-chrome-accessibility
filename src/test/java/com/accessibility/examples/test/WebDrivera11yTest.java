package com.accessibility.examples.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.accessibility.ProcessResponse;
import com.itextpdf.text.DocumentException;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Created by nilli on 8/17/17.
 */
public class WebDrivera11yTest {

  public String response;
  @Test
  public void simpleWebDriveraXeAccessibilityTest()
      throws IOException, InterruptedException, DocumentException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.starbucks.com/");
    driver.manage().window().maximize();
    Thread.sleep(3000);
    String response = ProcessResponse.aXescanner(driver);
    driver.quit();
  }
  
  @Test
  public void simpleWebDriverAccessibilityGoogleChromeTest()
      throws IOException, InterruptedException, DocumentException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.starbucks.com/");
    driver.manage().window().maximize();
    Thread.sleep(3000);
    String response = ProcessResponse.googleChromeScanner(driver);
    driver.quit();
  }
  
  //This test is for verifying the axe-core scanning with 
  @Test
  public void simpleWebDriveraXeAccessibilityTestwithRules()
      throws IOException, InterruptedException, DocumentException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.starbucks.com/");
    driver.manage().window().maximize();
    Thread.sleep(3000);
    String ruleset = "{ rules: { 'accesskeys': { enabled: false } } }";
    String response = ProcessResponse.aXescannerWithRules(driver,ruleset);
    driver.quit();
  }
}
