package loanDisbursal;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoanDisbursalStepDefinition {
	
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

	@When("^user navigates to loan disbursal Page$")
	public void user_navigates_to_loan_disbursal_Page() {
		
		driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[3]/a")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
	}

	@And("^user selects loan requests option$")
	public void user_selects_loan_requests_option() {
	   
		Select drop1 = new Select(driver.findElement(By.xpath("//*[@id=\"Loan Disbursal Form\"]/div/div/select")));
		drop1.selectByVisibleText("Retrieve all loan requests");
	}

	@And("^clicks the submit button$")
	public void clicks_the_submit_button() throws InterruptedException {
	  
		driver.findElement(By.xpath("//*[@id=\"Loan Disbursal Form\"]/div/div/button")).click();
		Thread.sleep(3000);
		
	}

	@Then("^user gets Approved Loan Request Details$")
	public void user_gets_Approved_Loan_Request_Details() {
		
		assertEquals("Loan Request Details", driver.getTitle());
	}

}
