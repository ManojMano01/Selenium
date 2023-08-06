package firstone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

public class test {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.edgedriver().setup();

		System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();

		driver.navigate().to("https://www.flipkart.com/");

		WebElement user = driver.findElement(By.xpath("//input[@type='text']"));

		WebElement user1 = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		user1.click();

		if (user.isDisplayed()) {
			user.sendKeys("Redmi mobiles");
			String attribute = user.getAttribute("value");
			System.out.println(attribute);
		} else {
			System.out.println("User field s not present ");
		}

		WebElement link = driver.findElement(By.xpath("//button[@type='submit']"));
		link.click();

		if (link.isEnabled()) {
			String text = link.getText();
			System.out.println(text);
			link.click();

		}
		Thread.sleep(3000);
		List<WebElement> link1 = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		Map<String, String> mp = new HashMap<String, String>();

		for (int i = 0; i < link1.size(); i++) {
			WebElement name = link1.get(i);
			String s1 = name.getText();

			List<WebElement> link2 = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

			for (int j = i; j == i; j++) {
				WebElement price = link2.get(j);
				String s2 = price.getText();

				mp.put(s1, s2);

			}

		}
		Set<java.util.Map.Entry<String, String>> g = mp.entrySet();

		File f = new File("D:\\Project\\Map.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("Seeet1");
		Row r = s.createRow(0);
		Cell c2 = r.createCell(0);
		c2.setCellValue("Mobiles");
		Cell c3 = r.createCell(1);
		c3.setCellValue("Prices");
		FileOutputStream f1 = new FileOutputStream(f);
		w.write(f1);
		f1.close();

		int i = 1;
		for (java.util.Map.Entry<String, String> e : g) {

			FileInputStream f3 = new FileInputStream(f);
			Workbook ww = new XSSFWorkbook(f3);
			Sheet s1 = ww.getSheet("Seeet1");
			Row rr = s1.createRow(i);
			Cell cc = rr.createCell(0);
			System.out.println(e.getKey());
			cc.setCellValue(e.getKey());
			FileOutputStream f4 = new FileOutputStream(f);
			ww.write(f4);
			f4.close();

			i++;

		}
		i = 1;
		for (java.util.Map.Entry<String, String> e : g) {
			FileInputStream f3 = new FileInputStream(f);
			Workbook ww = new XSSFWorkbook(f3);
			Sheet s1 = ww.getSheet("Seeet1");
			Row rr = s1.getRow(i);
			Cell cc = rr.createCell(1);
			cc.setCellValue(e.getValue());
			FileOutputStream f4 = new FileOutputStream(f);
			ww.write(f4);
			f4.close();
			i++;
		}
	}
}
