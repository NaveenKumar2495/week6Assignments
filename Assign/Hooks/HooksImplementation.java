package week6.Assign.Hooks;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import week6.Assign.Base.ProjectSpecificMethod;


public class HooksImplementation extends ProjectSpecificMethod {
	
	@Before	
	public void precondition() {
				driver = new ChromeDriver() ;
				driver.manage().window().maximize();
				//Loading the URL
				driver.get("http://leaftaps.com/opentaps/");
				//Entering the username, Password and clicking on Login 
				driver.findElement(By.id("username")).sendKeys("demosalesmanager")	;	
				driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa")	;
				driver.findElement(By.className("decorativeSubmit")).click();
				//Clicking on CRM/SFA link			
				driver.findElement(By.linkText("CRM/SFA")).click() ;
	
	}

	@After
	public void postCondition() {
				driver.close();
	}

}
