package com.accessibility;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import com.a11y.Report.PDFReport;
import com.deque.axe.AXE;
import com.deque.axe.AXEResponseParser;
import com.itextpdf.text.DocumentException;

public class ProcessResponse {

  private static final URL scriptUrl = ProcessResponse.class.getResource("/axe.min.js");
  private static final String lineSeparator = System.getProperty("line.separator");

  public static String aXescanner(WebDriver driver)
      throws IOException, DocumentException, InterruptedException {
    String response=null;
    JSONObject responseJSON;
    try {
      responseJSON = new AXE.Builder(driver, scriptUrl).analyze();
      response = AXEResponseParser.responseParser(responseJSON).toString();
      PDFReport.createPDF(response);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return response;
  }

  public static String aXescannerWithRules(WebDriver driver, String strOptions)
      throws IOException, DocumentException, InterruptedException {
    String response=null;
    JSONObject responseJSON;
    try {
      responseJSON = new AXE.Builder(driver, scriptUrl).options(strOptions).analyze();
      response = AXEResponseParser.responseParser(responseJSON).toString();
      PDFReport.createPDF(response);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return response;
  }

  public static String googleChromeScanner(WebDriver driver)
      throws IOException, DocumentException, InterruptedException {
    String response=null;
    try {
      final StringBuilder sb = new StringBuilder();
      sb.append(lineSeparator);
      AccessibilityScanner scanner = new AccessibilityScanner(driver);
      Map<String, Object> audit_report = scanner.runAccessibilityAudit();
      if (audit_report.containsKey("plain_report")) {
        sb.append(
            "*************************" + "Accessibility Results" + "*************************");
        sb.append(lineSeparator);
        sb.append(audit_report.get("plain_report").toString());
        sb.append(lineSeparator);
      }
      response = sb.toString();
      PDFReport.createPDF(response);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return response;
  }
}
