package week6.Assign.Stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountEditStaticPara {


public ChromeDriver driver ; 
	
/*
 * @Given("Launch the browser and Load the salesforce {string}") public void
 * launch_the_browser_and_load_the_salesforce_url(String url) { driver = new
 * ChromeDriver() ; driver.manage().window().maximize(); driver.get(url);
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8)) ; }
 * 
 * @When("Enter the salesforce username as {string}") public void
 * enter_the_salesforce_username_as(String uname) {
 * driver.findElement(By.id("username")).sendKeys(uname) ;
 * 
 * }
 * 
 * @And("Enter the salesforce password as {string}") public void
 * enter_the_salesforce_password_as(String pass) {
 * driver.findElement(By.id("password")).sendKeys(pass) ; }
 * 
 * @And("Click on Salesforce login button") public void
 * click_on_salesforce_login_button() {
 * driver.findElement(By.id("Login")).click(); }
 * 
 * @And("Click on toggle menu buttonon the left corner") public void
 * click_on_toggle_menu_buttonon_the_left_corner() {
 * driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click() ; }
 */
	
	@And("Click view All and click All Apps dropdown")
	public void click_view_all_and_click_all_apps_dropdown() {
		driver.findElement(By.xpath("//button[text() ='View All']")).click() ;
		driver.findElement(By.xpath("//span[text()='All Apps']/preceding-sibling::lightning-primitive-icon")).click() ;
	}

	@And("Select Accounts from All Items section")
	public void select_accounts_from_all_items_section() {
		driver.findElement(By.xpath("//p[text()='Accounts']")).click() ;
	}

	@And("Search for Account {string} which needs to be edited")
	public void search_for_account_which_needs_to_be_edited(String accName) {
		driver.findElement(By.xpath("//input[@name = 'Account-search-input']")).sendKeys(accName) ;
		driver.findElement(By.xpath("//input[@name = 'Account-search-input']")).sendKeys(Keys.ENTER) ;
	}

	@And("Click on the Account name")
	public void click_on_the_account_name() throws InterruptedException {
		System.out.println("searching the Account" );
		//I am getting Stale element exception even after using the Explicit wait that's why used the Thread.sleep
		Thread.sleep(9000) ;
		driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody/tr/th/span/a")).click() ;
	}

	@And("Click the dropdown on right side and select Edit option")
	public void click_the_dropdown_on_right_side_and_select_edit_option() {
		driver.findElement(By.xpath("(//li[@class='visible'])[3]/following-sibling::li")).click() ;
		driver.findElement(By.xpath("//span[text() ='Edit']")).click() ;
	}

	@And("Enter the Phone number as {string}")
	public void enter_the_phone_number_as(String phNum) {
		driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys(phNum) ;

	}

	@And("Set the Type as Technology partner and Industry as Healthcare")
	public void set_the_type_as_technology_partner_and_industry_as_healthcare() {
		//Added extra steps to scroll down
		driver.findElement(By.xpath("//input[@name='NumberOfEmployees']")).sendKeys("") ;
		
		driver.findElement(By.xpath("(//button[@role='combobox'])[2]")).click();
		driver.findElement(By.xpath("//span[text() ='Technology Partner']")).click() ; 
		//using sendkeys function to scroll down the dropdown
		driver.findElement(By.xpath("(//button[@role='combobox'])[4]")).sendKeys("Healthcare") ;
		driver.findElement(By.xpath("//span[text() ='Healthcare']")).click() ;
	}

	@And("Enter the billing address as {string}")
	public void enter_the_billing_address_as(String billingAdd) {
		driver.findElement(By.xpath("//textarea[@name='street']")).sendKeys(billingAdd) ;
	}

	@And("Enter the shipping address as {string}")
	public void enter_the_shipping_address_as(String shippingAdd) {
		driver.findElement(By.xpath("(//textarea[@name='street'])[2]")).sendKeys(shippingAdd) ;
	}

	@And("Set the Customer priority as Low and SLA as Silver")
	public void set_the_customer_priority_as_low_and_sla_as_silver() {
		  driver.findElement(By.xpath("(//button[@role='combobox'])[5]")).sendKeys("Low") ; 
		  driver.findElement(By.xpath("//span[text() ='Low']")).click() ;
		  
		  driver.findElement(By.xpath("(//button[@role='combobox'])[6]")).sendKeys("Silver") ; 
		  driver.findElement(By.xpath("//span[text() ='Silver']")).click() ;
	}

	@And("Set the Active as No and upsell opportunity as No")
	public void set_the_active_as_no_and_upsell_opportunity_as_no() {
		 driver.findElement(By.xpath("(//button[@role='combobox'])[7]")).sendKeys("No") ; 
		 driver.findElement(By.xpath("//span[text() ='No']")).click() ;
		 
		 driver.findElement(By.xpath("(//button[@role='combobox'])[8]")).sendKeys("No") ; 
		 driver.findElement(By.xpath("(//span[text() ='No'])[3]")).click() ;
	}

	@And("Click on Save button")
	public void click_on_save_button() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click() ;
	}

	@Then("Verify the Phone number {string}")
	public void verify_the_phone_number(String phoneNum) {
		String phone = driver.findElement(By.xpath("//p[@title='Phone']/following-sibling::p/slot/records-output-phone/lightning-formatted-phone/a")).getText();
		// System.out.println(phNum);
		if(phone.equals(phoneNum)) {
			System.out.println("Phone number verified and Account edited successfully");
		} 
		else {
			System.out.println("Account edit was Unsuccessfull");
		}
	}

}
