package testTitle;
import org.openqa.selenium.By;
public class RedirectToADSWorkCenter {
public static void main(String args[])
{
	
	RedirectToAdsServices.driver = null;
	RedirectToAdsServices.before();
	RedirectToAdsServices.Login();
	RedirectToAdsServices.selectADS();
	Boolean presence = RedirectToAdsServices.driver.findElement(By.xpath("//div[@class ='tab_holder']/div[2]/span[@id='ctl00_contentPageHeader_lblHeader']")).isDisplayed();
	if(presence == true)
	{
		System.out.println("User successfully redirected to the work center of selected service");
	}
	RedirectToAdsServices.driver.close();
	System.exit(0);
	}
	
}

