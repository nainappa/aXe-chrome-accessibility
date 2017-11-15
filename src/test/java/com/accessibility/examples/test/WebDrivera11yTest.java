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
  public void simpleWebDriverAccessibilityTest()
      throws IOException, InterruptedException, DocumentException {
    System.setProperty("webdriver.chrome.driver", "C://MyProjects//chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.stubhub.com/");
    driver.manage().window().maximize();
    Thread.sleep(3000);
    ProcessResponse.scanner(driver);
    driver.findElement(By.xpath("//a[text()='Sell tickets']/parent::h3")).click();
    Thread.sleep(9000);
    ProcessResponse.scanner(driver);
    driver.quit();
  }
}
