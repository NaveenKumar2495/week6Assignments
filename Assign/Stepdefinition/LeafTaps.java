package week6.Assign.Stepdefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import week6.Assign.Base.ProjectSpecificMethod;

public class LeafTaps extends ProjectSpecificMethod {
	
	public String AccountId ;
	
	@When("Click on leaftaps Accounts Tab")
	public void click_on_leaftaps_accounts_tab() {
		driver.findElement(By.linkText("Accounts")).click() ;
	}
	
	@And("Click on create account in shortcut section")
	public void click_on_create_account_in_shortcut_section() {
		driver.findElement(By.linkText("Create Account") ).click() ;
	}

	@And("Enter Account name as {string}")
	public void enter_account_name_as_acc_name(String accName) {
		driver.findElement(By.id("accountName")).sendKeys(accName)	;
	}

	@And("Enter the number of employee as {string}")
	public void enter_the_number_of_employee_as(String noOfEmp) {
		driver.findElement(By.id("numberEmployees")).sendKeys(noOfEmp)	;
	}

	@And("Select the Industry as {string}")
	public void select_the_industry_as(String indus) {
		Select Industry = new Select(driver.findElement(By.name("industryEnumId"))) ;
		Industry.selectByVisibleText(indus) ;
	}

	@And("Enter description as {string}")
	public void enter_description_as(String description) {
		driver.findElement(By.name("description")).sendKeys(description)	;
	}

	@And("Enter phone number as {string}")
	public void enter_phone_number_as(String phoneNum) {
		driver.findElement(By.id("primaryPhoneNumber")).sendKeys(phoneNum)	;
	}

	@And("Select the state as {string}")
	public void select_the_state_as(String state) {
		Select st = new Select(driver.findElement(By.id("generalStateProvinceGeoId"))) ;
		st.selectByVisibleText(state) ;
	}
	
	@And("Click on account save button")
	public void click_on_account_save_button() {
		driver.findElement(By.className("smallSubmit")).click();
	}

	@Then("Verify the Account got created")
	public void verify_the_account_got_created() {
		String title = driver.getTitle() ;
		System.out.println(title);
		if (title.contentEquals("Account Details | opentaps CRM")) {
			System.out.println("Account got created successfully");
		}
		else{
			System.out.println("Account not created");
		}
	}

	@And("Click on find Account in shortcut section")
	public void click_on_find_account_in_shortcut_section() {
		driver.findElement(By.linkText("Find Accounts") ).click() ;
	}

	@And("Click on phone tab")
	public void click_on_phone_tab() {
		driver.findElement(By.xpath("//span[text()='Phone']")).click() ;
	}

	@And("Enter the phone number {string} and click on find accounts button")
	public void enter_the_phone_number_and_click_on_find_accounts_button(String phoneNum) {
		driver.findElement(By.name("phoneNumber")).sendKeys(phoneNum) ;		
		driver.findElement(By.xpath("//button[text()='Find Accounts']")).click() ;
	}

	@And("Click on the first account which needs to be edited")
	public void click_on_the_first_account_which_needs_to_be_edited() throws InterruptedException {
		Thread.sleep(6000) ;
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click() ;
	}

	@And("Click on account edit button")
	public void click_on_edit_button() {
		driver.findElement(By.linkText("Edit") ).click() ;
	}

	@And("Clear the description value")
	public void clear_the_description_value() {
		driver.findElement(By.name("description")).clear()	;
	}

	@And("Enter the important not as {string}")
	public void enter_the_important_not_as(String impNote) {
		driver.findElement(By.name("importantNote")).sendKeys(impNote)	;
	}

	@Then("Verify the Account got edited successfully")
	public void verify_the_account_got_edited_successfully() {
		String title = driver.getTitle() ;
		System.out.println(title);
		if (title.contentEquals("Account Details | opentaps CRM")) {
			System.out.println("Account got edited successfully");
		}
		else{
			System.out.println("Account not edited");
		}
	}

	@And("Store the first account id and click on it")
	public void store_the_first_account_id_and_click_on_it() throws InterruptedException {
		Thread.sleep(5000);
		AccountId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText() ;
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click() ;
		System.out.println(AccountId);
	}

	@And("Click on Deactivate Account")
	public void click_on_deactivate_account() {
		driver.findElement(By.xpath("//a[@class ='subMenuButtonDangerous']") ).click() ;
	}

	@And("Accept the alert")
	public void accept_the_alert() {
		Alert alert = driver.switchTo().alert() ;
	//	System.out.println(alert.getText());
		alert.accept() ;
	}

	@Then("Verify that Account got deleted successfully")
	public void verify_that_account_got_deleted_successfully() throws InterruptedException {
	 String warning = driver.findElement(By.xpath("//span[@class ='subSectionWarning']")).getText() ;
	 System.out.println(warning);
		
			driver.findElement(By.linkText("Find Accounts") ).click() ;
			driver.findElement(By.name("id")).sendKeys(AccountId) ;
			driver.findElement(By.xpath("//button[text()='Find Accounts']")).click() ;
			Thread.sleep(6000) ;
			String errmsg = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText() ;
			System.out.println(errmsg);
			if(errmsg.equals("No records to display")) {
				System.out.println("Account id "+AccountId+" got deleted successfully");
			}			
			else {
			System.out.println("Account didn't get deleted");
		}				
		
	}

	
	

}
