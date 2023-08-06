package firstone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class webDriver {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");
		EdgeOptions er = new EdgeOptions();
		
		//er.addArguments("window-size=1200,1000");
		
		er.addArguments("--incognito");
		er.addArguments("--start-maximized");

	
		WebDriver wb = new EdgeDriver(er);
		
		wb.get("https://www.instagram.com/");
		
		
		String v = wb.getCurrentUrl();
		
		
		File f = new File("D:\\Project\\Excel.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Dataa");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue(v);
		FileOutputStream f1 = new FileOutputStream(f);
		w.write(f1);
		f1.close();
		wb.get("https://www.google.com/");
		wb.get(v);
		
		FileInputStream f2 = new FileInputStream(f);
		Workbook w1 = new XSSFWorkbook(f2);
		Sheet s1 = w1.getSheet("Dataa");
		Row r1 = s1.getRow(0);
		Cell c1 = r1.getCell(0);
		String v1 = c1.getStringCellValue();
		f2.close();
		
		if (v1.equals(v)) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		
	}

}

