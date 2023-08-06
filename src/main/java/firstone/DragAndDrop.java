package firstone;

import java.awt.event.ActionEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

		
		public static void main(String[] args) throws IOException, InterruptedException {
			
			System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver();			
			driver.get("https://demo.guru99.com/test/drag_drop.html");
			driver.manage().window().maximize();
			
			Thread.sleep(3000);
			
			WebElement s1 = driver.findElement(By.xpath("//*[contains(text(),'SALES')]"));
			WebElement s2 = driver.findElement(By.xpath("(//*[contains(text(),'5000')])[2]"));
			
			
			WebElement t1 = driver.findElement(By.xpath("(//li[@class='placeholder'])[3]"));
			WebElement t2 = driver.findElement(By.xpath("(//li[@class='placeholder'])[4]"));
			
			Actions a = new Actions(driver);
			
			
			a.dragAndDrop(s1,t1).build().perform();
			Thread.sleep(3000);
			a.dragAndDrop(s2,t2).build().perform();
			
	}

}
