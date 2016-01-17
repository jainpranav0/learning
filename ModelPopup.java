package testTitle;

import org.openqa.selenium.By;

public class ModelPopup {
	public static void main(String args[]) {
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
			RedirectToAdsServices.driver.findElement(By.xpath("//td[@class= 'edit']/a/img[@style='border-width:0px;']")).click();
			System.out.println("Redirected to Dev eval survey page");
			RedirectToAdsServices.driver.findElement(By.id("ctl00_contentLeftNaviagation_ctl00_ISPAuth")).click();
			RedirectToAdsServices.driver.findElement(By.id("ctl00_contentMain_fupISP")).sendKeys("C:\\Users\\pranav-ja\\Desktop\\images\\14.jpg");
			RedirectToAdsServices.driver.findElement(By.id("ctl00_contentMain_btnUpload")).click();
			RedirectToAdsServices.driver.findElement(By.id("ctl00_contentMain_btnNew")).click();
}
}
}