package login;

import static org.junit.Assert.assertEquals;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	WebDriver driver;

	@Given("^user is on homepage$")
	public void user_is_on_homepage() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anibasu\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:9090/pecunianew/index.html");
	}

	@When("^user navigates to Login Page$")
	public void user_navigates_to_login_page() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/a")).click();
		String loginPage="http://localhost:9090/pecunianew/login.html";
		String actualURL=driver.getCurrentUrl();
		assertEquals(loginPage, actualURL);
	}
	

	@And("user enters {string} and {string}")
	public void user_enters_and(String username, String password) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"inputUsername\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys(password);
	
	}

	@And("^clicks on the submit button$")
	public void user_clicks_the_submit_button() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/form/button")).click();
		
	}
	
	@Then("^user navigates to main page$")
	public void user_navigates_to_main_page() throws InterruptedException {
		String mainPageTitle = driver.getTitle();
		String title= "Pecunia Bank";
		assertEquals(mainPageTitle, title);
		driver.quit();
	}
	
	
	
}
