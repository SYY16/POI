package com.lanou;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {
	public static String excelUrl = "C:\\Users\\Administrator\\Desktop\\1.xlsx";

	public static void main(String[] args) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(excelUrl));
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int rows = sheet.getPhysicalNumberOfRows();
			for (int i = 1; i < rows; i++) {
				XSSFRow row = sheet.getRow(i);
				if (row != null) {
					int cells = row.getPhysicalNumberOfCells();
					String value = "";
					for (int j = 0; j < cells; j++) {
						XSSFCell cell = row.getCell(j);
						if (cell != null) {
							switch (cell.getCellType()) {
							case HSSFCell.CELL_TYPE_FORMULA:
								break;
							case HSSFCell.CELL_TYPE_NUMERIC:
								value += cell.getNumericCellValue() + ",";
								break;
							case HSSFCell.CELL_TYPE_STRING:
								value += cell.getStringCellValue() + ",";
								break;
							default:
								value += "0";
								break;
							}
						}
					}
					String[] val = value.split(",");
					DBUtils dbUtils = new DBUtils();
					dbUtils.AddU("insert into people (name,gender,age) values(?,?,?)", val);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
