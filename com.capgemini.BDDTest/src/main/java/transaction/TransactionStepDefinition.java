package transaction;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransactionStepDefinition {
	
	WebDriver driver;
	
	@Given("^user is  on homepage$")
	public void user_is_on_homepage() {
	 
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

	@When("^user navigates to Transaction Page$")
	public void user_navigates_to_Transaction_Page() {
	   
		driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[2]/a")).click();
	}

	@And("^user clicks on credit using slip option$")
	public void user_clicks_on_credit_using_slip_option() {
		
		driver.findElement(By.xpath("/html/body/div[2]/div/a[1]")).click();
	}
	
	@And("^user navigates to credit using slip page$")
	public void user_navigates_to_credit_using_slip_page() {
		
		driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li/a")).click();
	}

	@And("^user enters valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_valid_and(String string, String string2) {
		driver.findElement(By.xpath("//*[@id=\"account-number \"]")).sendKeys(string);
		driver.findElement(By.xpath("//*[@id=\"credit-slip-amount \"]")).sendKeys(string2);
	}

	@And("^clicks submit button$")
	public void clicks_submit_button() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"credit-slip-form \"]/div[3]/button")).click();
		Thread.sleep(3000);
	}

	@Then("^user gets a credit using slip success message$")
	public void user_gets_a_credit_using_slip_success_message() {
		driver.findElement(By.xpath("//*[@id=\"success-toast-body\"]")).click();
		driver.close();
	}

}
