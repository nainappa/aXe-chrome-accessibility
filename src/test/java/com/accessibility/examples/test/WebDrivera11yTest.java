package com.accessibility.examples.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.accessibility.ProcessResponse;
import com.itextpdf.text.DocumentException;

/**
 * Created by nilli on 8/17/17.
 */
public class WebDrivera11yTest {

  @Test
  public void simpleWebDriverAXEAccessibilityTest()
      throws IOException, InterruptedException, DocumentException {
    String strOptions="";
    System.setProperty("webdriver.chrome.driver",
        "<Your driver path>");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.starbucks.com/");
    driver.manage().window().maximize();
    Thread.sleep(3000);
    ProcessResponse.aXescanner(driver);
    driver.quit();
  }
  
  @Test
  public void simpleWebDriverAccessibilityGoogleChromeTest()
      throws IOException, InterruptedException, DocumentException {
    System.setProperty("webdriver.chrome.driver",
        "<Your driver path>");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.starbucks.com/");
    driver.manage().window().maximize();
    Thread.sleep(3000);
    ProcessResponse.googleChromeScanner(driver);
    driver.quit();
  }
}
