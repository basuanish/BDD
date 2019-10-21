package loanRequest;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoanRequestStepDefinition {
	
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

	@When("^user clicks on Loan request option$")
	public void user_clicks_on_Loan_request_option() {
		
		driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[3]/a")).click();
	   
	}

	@And("^user navigates to Loan request Page$")
	public void user_navigates_to_Loan_request_Page() {
		driver.findElement(By.xpath("/html/body/div[2]/div/a[1]")).click();
	}

	@When("^user enters \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_enters(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
	   
		driver.findElement(By.xpath("//*[@id=\"AccountId\"]")).sendKeys(string);
		driver.findElement(By.xpath("//*[@id=\"LoanAmount\"]")).sendKeys(string2);
		driver.findElement(By.xpath("//*[@id=\"Tenure\"]")).sendKeys(string3);
		driver.findElement(By.xpath("//*[@id=\"CreditScore\"]")).sendKeys(string4);
		driver.findElement(By.xpath("//*[@id=\"roi\"]")).sendKeys(string5);
		Select drop1 = new Select(driver.findElement(By.xpath("//*[@id=\"loantype\"]")));
		drop1.selectByVisibleText(string6);
		Select drop2 = new Select(driver.findElement(By.xpath("//*[@id=\"status\"]")));
		drop2.selectByVisibleText(string7);
	}

	@When("^clicks the submit button$")
	public void clicks_the_submit_button() throws InterruptedException {
	  
		driver.findElement(By.xpath("/html/body/form/button[1]")).click();
		Thread.sleep(3000);
	}

	@Then("^user gets loan request added pop-up$")
	public void user_gets_loan_request_added_pop_up() {
	    
		assertEquals("Loan Request Details", driver.getTitle());
	}

}
