package testTitle;

import java.io.FileNotFoundException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class POMTitle {
	static String baseurl= "http://192.168.2.220/ittdemo/";
	static WebDriver driver;
	static String expectedTitle= "POM::Login";
  	static String actualTitle;
	@BeforeTest
	void before()
	{
		System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
	  	driver= new ChromeDriver();
	  	driver.manage().window().maximize();
	  	driver.get(baseurl);
	}
  @Test
  public void Title()
  {
  	actualTitle= driver.getTitle();
  	Assert.assertEquals(actualTitle, expectedTitle);
  }
 
  @Test(priority=1)
  public void WrongLogin(String usname, String password) throws FileNotFoundException
  {
	    driver.findElement(By.id("txtUsername")).clear();
	    driver.findElement(By.id("txtUsername")).sendKeys(usname);
	    driver.findElement(By.id("txtPassword")).clear();
	    driver.findElement(By.id("txtPassword")).sendKeys(password);
	    driver.findElement(By.id("ImageButton1")).click();
	    boolean Loginalert = driver.findElement(By.id("lblError")).isDisplayed();
	    Assert.assertEquals(Loginalert, true);
  }
  @Test(priority=2)
  public void CorrectLogin()
  {
	    driver.findElement(By.id("txtUsername")).clear();
	    driver.findElement(By.id("txtUsername")).sendKeys("test.user");
	    driver.findElement(By.id("txtPassword")).clear();
	    driver.findElement(By.id("txtPassword")).sendKeys("pa55word");
	    driver.findElement(By.id("ImageButton1")).click();
	    boolean correctLogin = driver.findElement(By.id("btnLogout")).isDisplayed();
	    Assert.assertEquals(correctLogin, true);
  }
  @AfterTest
  void after()
  {
	  driver.close();
	  System.exit(0);
  }
  
}
