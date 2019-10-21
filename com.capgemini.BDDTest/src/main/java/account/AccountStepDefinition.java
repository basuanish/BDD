package account;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountStepDefinition {
	
	WebDriver driver;
	@Given("^user is on the homepage$")
	public void user_is_on_the_homepage() {
	   
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anibasu\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:9090/pecunianew/index.html");
		driver.findElement(By.xpath("/html/body/a")).click();
		driver.findElement(By.xpath("//*[@id=\"inputUsername\"]")).sendKeys("anish@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("12345");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/form/button")).click();
		assertEquals("Pecunia Bank", driver.getTitle());
		
	}

	@When("^user navigates to account Page$")
	public void user_navigates_to_account_Page() {
		driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[1]/a")).click();
		
	   
	}

	@And("^user clicks on Update contact details$")
	public void user_clicks_on_Update_contact_details() {
		driver.findElement(By.xpath("/html/body/div[2]/div/a[3]")).click();
	   
	}

	@And("^user navigates to Update contact details$")
	public void user_navigates_to_Update_contact_details() {
		
		assertEquals("Update contact details", driver.getTitle());
	  
	}

	@And("^user enters valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_valid_and(String string, String string2) {
	 
		driver.findElement(By.xpath("//*[@id=\"account-id\"]")).sendKeys(string);
		driver.findElement(By.xpath("//*[@id=\"contact\"]")).sendKeys(string2);
		
		
	}

	@And("^clicks the update contact button$")
	public void clicks_the_update_contact_button() {
	  driver.findElement(By.xpath("//*[@id=\"update-contact-form\"]/center/button")).click();
		
	}

	@Then("^user gets a successfully message$")
	public void user_gets_a_successfully_message() throws InterruptedException {
	   
	   
	    Thread.sleep(4000);
		assertEquals("http://localhost:9090/pecunianew/updateContact.html", driver.getCurrentUrl());
		driver.close();
	}

}
