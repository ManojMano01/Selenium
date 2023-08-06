package firstone;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		WebDriverManager.edgedriver().setup();
		System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		
		driver.navigate().to("https://www.flipkart.com/");
		driver.manage().window().maximize();
		try {driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();}
		catch (Exception e) {
			// TODO: handle exception
		}
	
	driver.findElement(By.name("q")).sendKeys("Samsung Mobiles",Keys.ENTER);
		Thread.sleep(3000);
	Map<String, String> m = new HashMap<String, String>();
	  
		List<WebElement> mobileName = driver.findElements(By.xpath("//div[@class=\"_4rR01T\"]"));
			for(int i = 0; i<mobileName.size();i++) {
				WebElement mobile = mobileName.get(i);
				String text = mobile.getText();
				
		   List<WebElement> mobilePrice = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
			   for(int j = i ; j==i ; j++) {
				   WebElement Price = mobilePrice.get(j);
				   String text1 = Price.getText();
				
				 	  m.put(text, text1);
				      Set<Entry<String, String>> entrySet = m.entrySet() ;
				      for(Entry<String, String> entry : entrySet) {
				      System.out.println(entry);
			}
			
			}
			}
			
			
			
			
		
		
	}
}


