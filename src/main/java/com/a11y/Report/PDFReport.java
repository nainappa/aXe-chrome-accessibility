package com.a11y.Report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFReport {
  public static String strReportFolderName = "";
  public static String strReportFilePath = "";
  public static String strRootFolderPath;
  public static String strReportFolderPath="";
  public static String strTestIterationErrMsg="";
  public static boolean blnTestReportMethodFlag;
  public static boolean blnReportRowIDFlag;
  public static String strTestRowNumber;
  public static String strImgfilePath;
  public static String strWebPagePath;
  
  
  public static void createPDF(String sb) throws DocumentException, InterruptedException, IOException{
    File file;
    FileOutputStream pdfFileout;
    Document doc = new Document(PageSize.A4, 36, 36, 50, 40);
    Font red = new Font(FontFamily.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK);
    String path=System.getProperty("user.dir");
    // generate a pdf file
    file = new File(path + "/Accessibility Results");
    if (!file.exists()) {
        if (file.mkdir()) {
            System.out.println("Directory is created!");
        } else {
            System.out.println("Failed to create directory!");
        }
    }
    File pdfFile = new File(
            path + "/Accessibility Results" + "/" + "Accessibility Results"+ new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + ".pdf");
    pdfFileout = new FileOutputStream(pdfFile);
    PdfWriter writer=PdfWriter.getInstance(doc, pdfFileout);
    HeaderFooterPageEvent event = new HeaderFooterPageEvent();
    writer.setPageEvent(event);
    doc.open();
    Thread.sleep(5000);
    Chunk redText = new Chunk(sb, red);
    Paragraph para = new Paragraph();
    para.add(redText);
    doc.add(para);
    
    // close pdf file
    doc.close();
    pdfFileout.close();
  }
  
  
}
