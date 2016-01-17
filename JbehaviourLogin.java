package testTitle;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JbehaviourLogin {
	WebDriver driver;
	public static By userName = By.id("txtUsername");
    public static By password = By.id("txtPassword");
	public static By Login = By.id("ImageButton1");

	@Given("need to login CPI application")
	void Login()
	{
		System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://192.168.2.220/ittdemo/");
	}
	@When("enter right credentials")
	void Credentials()
	{
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys("test.user");
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("pa55word");
		driver.findElement(Login).click();
	}
	@Then("Service selection appears ")
	void CorrectLogin()
	{
		boolean service = driver.findElement(By.id("ddlServices")).isDisplayed();
		Assert.assertEquals(service, true);
	}
	@When("Wrong credentials")
	void WrongCredentials()
	{
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys("test.user");
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("pa5");
		driver.findElement(Login).click();
	}
	@Then("Service selection not appears ")
	void CannotLogin()
	{
		boolean service = driver.findElement(By.id("ddlServices")).isDisplayed();
		Assert.assertEquals(service, false);
	}
}
