package firstone;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class JavaScript {
	public static void main(String[] args) throws IOException, InterruptedException,NullPointerException {
		
		System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();			
		driver.get("https://www.facebook.com//");
		driver.manage().window().maximize();
	
		Thread.sleep(3000);
		
		WebElement email = driver.findElement(By.id("email"));
		WebElement pass = driver.findElement(By.id("pass"));
		WebElement log = driver.findElement(By.xpath("//button[@name='login']"));
		
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("arguments[0].setAttribute('value','mayandi@gmal.com')",email);
		j.executeScript("arguments[0].setAttribute('value','mayandi')",pass);
		
		//j.executeScript("arguments[0].click()",log);
		
		j.executeAsyncScript("window.scrollBy(0,200)");
		
		Thread.sleep(3000);
		
		j.executeAsyncScript("window.scrollBy(0,-200)");
		
		
	}
	

}
