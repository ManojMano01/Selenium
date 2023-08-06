package firstone;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class test1 {
public static void main(String[] args) throws IOException, InterruptedException,NullPointerException,Throwable  {
		
		System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();			
		driver.get("https://www.facebook.com//");
		driver.manage().window().maximize();
	
		Thread.sleep(3000);
		
		WebElement user = driver.findElement(By.id("email"));
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		user.sendKeys("selenium");
		
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("arguments[0].setAttribute('style','border:2px solid red;background:yellow')",user );
		
		TakesScreenshot s = (TakesScreenshot)driver;
		File ss = s.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\jp\\eclipse-workspace\\firstone\\src\\main\\java\\firstone\\ScreenShot.png");
		FileUtils.copyFile(ss, f);
		
}

}
