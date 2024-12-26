package week6.Assign.Stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Day1SalesAccount {
	
	public ChromeDriver driver ; 
	
	
	  @Given("Launch the browser and Load the salesforce url") 
	  public void launch_the_browser_and_load_the_salesforce_url() { 
		  driver = new ChromeDriver() ; 
		  driver.manage().window().maximize(); driver.get("https://login.salesforce.com");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8)) ; }
	  
	  @When("Enter the salesforce username and password") 
	  public void enter_the_salesforce() {
	  driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com") ;
	  driver.findElement(By.id("password")).sendKeys("leaf@2024") ;
	  }
	  
	  @And("Click on Salesforce login button") 
	  public void click_on_salesforce_login_button() {
	  driver.findElement(By.id("Login")).click(); 
	  }
	  
	  @And("Click on toggle menu buttonon the left corner") 
	  public void click_on_toggle_menu_buttonon_the_left_corner() {
	  driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click() ; 
	  }
	 

	@And("Click view All and click Sales from App Launcher")
	public void click_view_all_and_click_sales_from_app_launcher() {
		driver.findElement(By.xpath("//button[text() ='View All']")).click() ;
		driver.findElement(By.xpath("//p[text()='Sales']")).click() ;
	}

	@And("Click on Accounts Tab")
	public void click_on_accounts_tab() {
		driver.findElement(By.xpath("//a[@title='Accounts']/following-sibling::one-app-nav-bar-item-dropdown/div")).click() ;
	}

	@And("Click on New Account button")
	public void click_on_new_account_button() {
		WebElement entity = driver.findElement(By.xpath("//a[@role='menuitem']")) ;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", entity) ;
	}

	@And("Enter the Account name and no of Employees")
	public void enter_the_account_name_and_no_of_employees() {
		driver.findElement(By.xpath("//input[@name ='Name']")).sendKeys("Naveen Kumar") ;
		//Added extra step for scrolling down the web page
		driver.findElement(By.xpath("//input[@name='NumberOfEmployees']")).sendKeys("0") ;		
	}

	@And("Select the ownership as public")
	public void select_the_ownership_as_public() {
		driver.findElement(By.xpath("(//button[@role='combobox'])[4]")).click() ;
		driver.findElement(By.xpath("//span[@title='Public']")).click() ;
	}

	@And("Click on save button")
	public void click_on_save_button() {
		driver.findElement(By.xpath("//button[@name ='SaveEdit']")).click() ;
	}

	@Then("Verify the sales account creation")
	public void verify_the_sales_account_creation() {
		String title = driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-text")).getText() ;
		System.out.println(title);
		if(title.contains("Naveen Kumar")) {
			System.out.println("Account created successfully");
		}
		else {
			System.out.println("Account not created");
		}

	}


}
