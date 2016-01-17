package testTitle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RedirectToAdsServices {
	public static WebDriver driver;
	public static By userName = By.id("txtUsername");
    public static By password = By.id("txtPassword");
	public static By Login = By.id("ImageButton1");
	public static void main(String args[])
	{
	before();
	Login();
	selectADS();
	driver.close();
	System.exit(0);
	
}
	public static void before()
	{
		System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://192.168.2.220/ittdemo/");
	}
	public static void Login()
	{
		driver.findElement(userName).clear();
		driver.findElement(userName).sendKeys("test.user");
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("pa55word");
		driver.findElement(Login).click();
		Boolean service = driver.findElement(By.id("ddlServices")).isDisplayed();
		if(service==true)
		{
			System.out.println("Login Successfully");
		}
		else
		{
			System.out.println("Problem in Login");
		}
	}
	public static void selectADS()
	{
		WebElement ServiceSelection = driver.findElement(By.id("ddlServices")); 
		Select mySelect= new Select(ServiceSelection);
		mySelect.selectByValue("1");
		driver.findElement(By.id("btnGo")).click();
		WebElement ServiceSelectionDropdown = driver.findElement(By.id("ctl00_ddlServices")); 
		Select selectedOption= new Select(ServiceSelectionDropdown);
		WebElement Option = selectedOption.getFirstSelectedOption();
		String selectedService= Option.getText();
		System.out.println("Seleceted service is "+selectedService);
		String ExpectedServiceSelected1= "Developmental Services -Adult";
		String ExpectedServiceSelected2= "Residential Habilitation";
		if(selectedService.equals(ExpectedServiceSelected1))
		{
			System.out.println("ADS Service selected Successfully");
		}
		else if(selectedService.equals(ExpectedServiceSelected2)){
			System.out.println("Reshab Service selected Successfully");
		}	
		else {
			System.out.println("Problem in selecting the service");
		}
	}
	
}
