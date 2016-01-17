package testTitle;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DevEvalSurveyTable {
	public static void main(String args[]) {
		List<WebElement> columns = null;
		RedirectToAdsServices.before();
		RedirectToAdsServices.Login();
		RedirectToAdsServices.selectADS();	
		Boolean presence = RedirectToAdsServices.driver.findElement(By.xpath("//div[@class ='tab_holder']/div[2]/span[@id='ctl00_contentPageHeader_lblHeader']")).isDisplayed();
		if(presence == true)
		{
			System.out.println("User successfully redirected to the work center of ADS service");
		}
		RedirectToAdsServices.driver.findElement(By.id("ctl00_isp")).click();
		Boolean presenceHeader= RedirectToAdsServices.driver.findElement(By.xpath("//div[@class='middle_right']/div[1]/div[@class='tab_middle']")).isDisplayed();
		if(presenceHeader==true)
		{
			System.out.println("Redirected to Dev eval/ISP module");
			WebElement htmltable=RedirectToAdsServices.driver.findElement(By.id("ctl00_contentMain_ctl00_grdClientMgmt"));
			List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
			System.out.println("no of rows: "+rows.size());
			for(int i=0;i<rows.size();i++)
			{
				columns=rows.get(i).findElements(By.tagName("td"));
				System.out.println("Number of columns:"+columns.size());
			}
			WebElement editcell = rows.get(rows.size()-3).findElement(By.className("edit"));
			editcell.findElement(By.tagName("a")).click();
		}
}
}