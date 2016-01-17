package testTitle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
	static String baseurl= "http://115.111.126.35/cpi/";
	@BeforeTest
	void before()
	{
		System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
	  	driver= new ChromeDriver();
	  	driver.manage().window().maximize();
	  	driver.get(baseurl);
	}
	@Test(dataProvider= "testdata")
	  private void WrongLogin(String usname, String password) throws FileNotFoundException
	  {
		    driver.findElement(By.id("txtUsername")).clear();
		    driver.findElement(By.id("txtUsername")).sendKeys(usname);
		    driver.findElement(By.id("txtPassword")).clear();
		    driver.findElement(By.id("txtPassword")).sendKeys(password);
		    driver.findElement(By.id("ImageButton1")).click();
		    boolean Loginalert = driver.findElement(By.id("lblError")).isDisplayed();
		    Assert.assertEquals(Loginalert, true);
	  }
	  @DataProvider(name="testdata")
	  public Object[][] myMethod() throws InterruptedException{
	      String[][] tabArray=null;
	  try{
	  FileInputStream file = new FileInputStream("E:\\Learnings\\credentials.xlsx");
	  XSSFWorkbook wordsheet = new XSSFWorkbook(file);
	  XSSFSheet sheet =wordsheet.getSheet("Sheet1");
	  for(int count = 1;count<=sheet.getLastRowNum();count++){
	      XSSFRow row = sheet.getRow(count);
	      System.out.println("Running test case " + row.getCell(0).toString());
	      // Run the test for the current test data row
	     // testLogin(row.getCell(1).toString(),row.getCell(2).toString());
	      WrongLogin(row.getCell(0).toString(),row.getCell(1).toString());
	  }
	  wordsheet.close();
	  }
	  catch(IOException e)
	  {
		  System.out.println(" file not found");
	  }
	return tabArray;
	  
	  
	  }
}
