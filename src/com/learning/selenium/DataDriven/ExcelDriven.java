package com.learning.selenium.DataDriven;

import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDriven {

  private XSSFWorkbook xssfWorkbook;
  private XSSFSheet xssfSheet;
  private XSSFRow xssfRow;
  private XSSFCell xssfCell;
  private FileInputStream excel;

  @Test
  public void Test() throws IOException {
//    String location = System.getProperty("user.dir");
//    excel = getExcel(location);
    String dataCell = getData(0,0);

    System.out.println("Before setting data " + dataCell);
    setData(0,0,"123");
    System.out.println("After setting data " + getData(0,0));

  }

  private FileInputStream getExcel(String location) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(location + "/resources/data.xlsx");
    return fileInputStream;
  }

  private String getData(int row, int col) throws IOException {
    // Hierachy Workbook > Sheet > Row > Column > grab/set Value
    String location = System.getProperty("user.dir");
    excel = getExcel(location);
    xssfWorkbook = new XSSFWorkbook(excel);
    xssfSheet = xssfWorkbook.getSheet("data");
    xssfRow = xssfSheet.getRow(row);
    xssfCell = xssfRow.getCell(col);
    return xssfCell.getStringCellValue().toString();

  }

  private void setData (int row, int col, String data)throws IOException{
    String location = System.getProperty("user.dir");
    excel = getExcel(location);
    xssfWorkbook = new XSSFWorkbook(excel);
    xssfSheet = xssfWorkbook.getSheet("data");
    xssfRow = xssfSheet.getRow(row);
    xssfCell = xssfRow.getCell(col);
    xssfCell.setCellValue(data);
    System.out.println(xssfCell.getStringCellValue());
    // data after setting not save to excel file, need to find the solution.
  }
}


