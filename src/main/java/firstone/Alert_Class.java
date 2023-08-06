package firstone;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_Class {

public static void main(String[] args) throws IOException, InterruptedException,NullPointerException,Throwable,SessionNotCreatedException  {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();			
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		
		
		//Simple Alert
	
		driver.findElement(By.id("alertButton")).click();
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();

		driver.findElement(By.id("timerAlertButton")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		String text = a.getText();
		System.out.println(text);
		a.accept();
		
		//Confirm Alert
		
		driver.findElement(By.id("confirmButton")).click();
		String text2 = a.getText();
		System.out.println(text2);
		a.accept();
		
		//Prompt Alert
		driver.findElement(By.id("promtButton")).click();
		String text3 = a.getText();
		System.out.println(text3);
		a.sendKeys("Selenium");
		a.accept();
}



}
