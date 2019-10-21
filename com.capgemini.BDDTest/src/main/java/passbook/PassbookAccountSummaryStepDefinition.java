package passbook;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PassbookAccountSummaryStepDefinition {
	
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

	@When("^user navigates to the Passbook Page$")
	public void user_navigates_to_the_Passbook_Page() {
		driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[4]/a")).click();
	}

	@And("^user clicks on Account Summary option$")
	public void user_clicks_on_Account_Summary_option() {
		driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
	}

	@And("^user enters valid \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
	public void user_enters_valid(String string, String string2, String string3) {
		driver.findElement(By.xpath("//*[@id=\"accountID\"]")).sendKeys(string);
		driver.findElement(By.xpath("//*[@id=\"startDate\"]")).sendKeys(string2);
		driver.findElement(By.xpath("//*[@id=\"endDate\"]")).sendKeys(string3);
	}

	@And("^taps on the submit button$")
	public void taps_on_the_submit_button() {
		driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/div/button")).click();
	}

	@Then("^user gets the account summary$")
	public void user_gets_the_account_summary() throws InterruptedException {
		assertEquals("Account Summary",driver.getTitle());
		Thread.sleep(4000);
		driver.close();
	}

}
