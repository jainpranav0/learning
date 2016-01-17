package testTitle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

public class ChangePassword {
	public static void main(String args[]) {
		RedirectToAdsServices.before();
		RedirectToAdsServices.Login();
		RedirectToAdsServices.selectADS();	
		Boolean presence = RedirectToAdsServices.driver.findElement(By.xpath("//div[@class ='tab_holder']/div[2]/span[@id='ctl00_contentPageHeader_lblHeader']")).isDisplayed();
		if(presence == true)
		{
			System.out.println("User successfully redirected to the work center of ADS service");
		}
RedirectToAdsServices.driver.findElement(By.id("ctl00_btnChangePawd")).click();	
//String parentWindowHandler = RedirectToAdsServices.driver.getWindowHandle(); // Store your parent window
String subWindowHandler = null;
Set<String> handles = RedirectToAdsServices.driver.getWindowHandles(); // get all window handles
Iterator<String> iterator = handles.iterator();
while (iterator.hasNext()){
    subWindowHandler = iterator.next();
}
RedirectToAdsServices.driver.switchTo().window(subWindowHandler); // switch to popup window
                                            // perform operations on popup

RedirectToAdsServices.driver.findElement(By.id("txtCurrentPwd")).clear();
RedirectToAdsServices.driver.findElement(By.id("txtCurrentPwd")).sendKeys("pa55word");
String Title=RedirectToAdsServices.driver.getTitle();
System.out.println(Title);
	}
	
}
