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
  
  public static void scanner(WebDriver driver) throws IOException, DocumentException, InterruptedException{
    final StringBuilder sb = new StringBuilder();
    sb.append(lineSeparator);
    AccessibilityScanner scanner = new AccessibilityScanner(driver);
    Map<String, Object> audit_report = scanner.runAccessibilityAudit();
    if (audit_report.containsKey("plain_report")) {
      sb.append("*************************" + "Accessibility Results" + "*************************");
      sb.append(lineSeparator);
      sb.append(audit_report.get("plain_report").toString());
      sb.append(lineSeparator);
    }
    JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();
    sb.append(AXEResponseParser.responseParser(responseJSON));
    PDFReport.createPDF(sb);
  }
}
