package addAccount;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addAccountStepDefinition {

	WebDriver driver;

	@Given("^user is on the homepage$")
	public void user_is_on_the_home_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anibasu\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:9090/pecunianew/index.html");
		driver.findElement(By.xpath("/html/body/a")).click();
		driver.findElement(By.xpath("//*[@id=\"inputUsername\"]")).sendKeys("anish@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("12345");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/form/button")).click();
		String title = driver.getTitle();
		assertEquals("Pecunia Bank", title);
	}

	@When("^user navigates to account Page$")
	public void user_navigates_to_account_Page() {
		driver.findElement(By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[1]/a")).click();

	}

	@And("^user clicks on add account option$")
	public void user_clicks_on_add_account_option() {
		driver.findElement(By.xpath("/html/body/div[2]/div/a[1]")).click();
	}

	@And("^user navigates to add account page$")
	public void user_navigates_to_add_account_page() {
		String actual = driver.getCurrentUrl();
		assertEquals("http://localhost:9090/pecunianew/addAccount.html", actual);
	}

	@And("^user enters valid \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void user_enters_valid(String string1, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8, String string9, String string10, String string11,
			String string12, String string13, String string14, String string15, String string16) {

		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(string1);
		driver.findElement(By.xpath("//*[@id=\"date-of-birth\"]")).sendKeys(string2);

		driver.findElement(By.xpath("//*[@id=\"address-line1\"]")).sendKeys(string3);

		driver.findElement(By.xpath("//*[@id=\"address-line2\"]")).sendKeys(string4);

		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(string5);

		driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys(string6);

		driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys(string7);

		driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys(string8);
		driver.findElement(By.xpath("//*[@id=\"aadhar\"]")).sendKeys(string9);
		driver.findElement(By.xpath("//*[@id=\"pan\"]")).sendKeys(string10);
		Select accountType = new Select(driver.findElement(By.xpath("//*[@id=\"accounttype\"]")));
		accountType.selectByVisibleText(string11);
		driver.findElement(By.xpath("//*[@id=\"branch-id\"]")).sendKeys(string12);
		driver.findElement(By.xpath("//*[@id=\"account-balance\"]")).sendKeys(string13);
		driver.findElement(By.xpath("//*[@id=\"account-interest\"]")).sendKeys(string14);
		Select gender = new Select(driver.findElement(By.xpath("//*[@id=\"gender\"]")));
		gender.selectByVisibleText(string15);
		driver.findElement(By.xpath("//*[@id=\"contact\"]")).sendKeys(string16);

	}

	@And("^clicks the add new account button$")
	public void clicks_the_add_new_account_button() {

		driver.findElement(By.xpath("//*[@id=\"new-account-form\"]/center/button")).click();
	}

	//
	@Then("^user gets account created successfully message$")
	public void user_gets_account_created_successfully_message() {

		driver.findElement(By.xpath("//*[@id=\"success-toast-body\"]")).click();
		assertEquals("http://localhost:9090/pecunianew/addAccount.html", driver.getCurrentUrl());
		driver.close();
	}
}
