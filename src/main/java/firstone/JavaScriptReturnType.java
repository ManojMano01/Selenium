package firstone;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class JavaScriptReturnType {
	
public static void main(String[] args) throws IOException, InterruptedException,NullPointerException  {
		
		System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();			
		driver.get("https://www.facebook.com//");
		driver.manage().window().maximize();
	
		Thread.sleep(3000);
		
		WebElement user = driver.findElement(By.id("email"));
		WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
		
		
		for (int i = 0; i < 20000; i++) {
			
		JavascriptExecutor j = (JavascriptExecutor)driver;
		
		j.executeScript("arguments[0].setAttribute('value','mayandi@gmal.com')",user,login);

		String  exe = j.executeScript("return document.readyState").toString();
		
		if (exe.equals("complete")) {
		
		System.out.println("page Redirected successfully");
		break;
	
		}
		}
}

}
