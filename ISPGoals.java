package testTitle;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ISPGoals {
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
			RedirectToAdsServices.driver.findElement(By.id("ctl00_contentLeftNaviagation_ctl00_ISPGoals")).click();
			RedirectToAdsServices.driver.findElement(By.id("ctl00_contentMain_ISPAccordian_Pane_0_content_txtObjectives")).clear();
			RedirectToAdsServices.driver.findElement(By.id("ctl00_contentMain_ISPAccordian_Pane_0_content_txtObjectives")).sendKeys("testing objective");
			Actions builder= new Actions(RedirectToAdsServices.driver);
			Action dragAndDrop = builder.clickAndHold(RedirectToAdsServices.driver.findElement(By.id("ctl00_contentMain_ISPAccordian_Pane_0_content_repGoals_ctl00_lblGoal")))
					   .moveToElement(RedirectToAdsServices.driver.findElement(By.id("ctl00_contentMain_ISPAccordian_Pane_0_content_repGoals_ctl00_lblGoal")))
					   .release(RedirectToAdsServices.driver.findElement(By.id("sortable-tar")))
					   .build();

					dragAndDrop.perform();
					RedirectToAdsServices.driver.findElement(By.id("ctl00_contentMain_ISPAccordian_Pane_0_content_btnAdd")).click();
					
		}
		else {
			
			System.out.println("Problem in Redirecting to Dev eval/ISP module");
		}
		
	}
	
}
