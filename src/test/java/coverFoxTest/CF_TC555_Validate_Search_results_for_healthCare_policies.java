package coverFoxTest;

import java.io.IOException;
//import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPOM.CoverFoxAddressDetailPage;
import coverFoxPOM.CoverFoxHealthPlanPage;
import coverFoxPOM.CoverFoxHealthPlanResultsPage;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.CoverFoxMemberDetailsPage;
import coverFoxUtility.Utility;
@Listeners(listeners.Listener.class)
public class CF_TC555_Validate_Search_results_for_healthCare_policies extends Base
{
	public static Logger logger;
	CoverFoxHomePage home;
	CoverFoxHealthPlanPage healthPlan;
	CoverFoxMemberDetailsPage memberDetails;
	CoverFoxAddressDetailPage addressDetails;
	CoverFoxHealthPlanResultsPage result;
	
  @BeforeClass
  public void launchBrowser() throws InterruptedException 
  {
	  logger=logger.getLogger("log4jcoverfoxInsurance");
	  //PropertyConfigurator.configure("log4jcoverfox.properties");
	  PropertyConfigurator.configure(getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "log4jcoverfox.properties");
	  logger.info("launching coverfox");
	  launchCoverFox();
	  home= new CoverFoxHomePage(driver);
	  healthPlan= new CoverFoxHealthPlanPage(driver);
	  addressDetails= new CoverFoxAddressDetailPage(driver);
	  memberDetails=new CoverFoxMemberDetailsPage(driver);
	  result= new CoverFoxHealthPlanResultsPage(driver);
	  
  }
  
  @BeforeMethod
  public void enterMemberDetails() throws InterruptedException, EncryptedDocumentException, IOException
  {
	  //Reporter.log("Clicking on gender button",true);
	  logger.info("Cliking on gender button");
	  home.clickOnFemaleButton();
	  Thread.sleep(3000);
	  
	 // Reporter.log("Clicking on next button",true);
	  logger.info("Cliking on next button");
	  healthPlan.clickOnNextButton();
	  Thread.sleep(4000);
	  
	  //Reporter.log("Handling age drop down",true)
	  logger.info("Handling age drop down");
	  //memberDetails.handledAgeDropDown(Utility.readDataFromExcel(1, 0));
	  memberDetails.handledAgeDropDown(Utility.readDataFromPropertiesFile("age"));
	 // Reporter.log("Clicking On next button",true);
	  logger.info("Cliking on next button");
	  memberDetails.clickOnnextButtonOnDetailPage();
	  Thread.sleep(3000);
	  
	 // Reporter.log("Entering Pin Code",true);
	  logger.info("Entering Pin Code");
	 // addressDetails.enterPinCode(Utility.readDataFromExcel(1, 1));
	  addressDetails.enterPinCode(Utility.readDataFromPropertiesFile("pincode"));
	 // Reporter.log("Entering Mobile Number",true);
	  logger.info("Entering mobile Number");
	  //addressDetails.enterMobileNumber(Utility.readDataFromExcel(1, 2));
	  addressDetails.enterMobileNumber(Utility.readDataFromPropertiesFile("mobnum"));
	 // Reporter.log("Clicking on continue button",true);
	  logger.info("Cliking on Continue button");
	  addressDetails.clickonContinueButton();
	  Thread.sleep(2000);
	    
  }
  @Test
  public void validateTestPlansFromTextAndBanners() throws InterruptedException, IOException
  {
	  Thread.sleep(5000);
	  //Reporter.log("Fetching number of results from text",true);
	  logger.info("Fetching number of results from text");
	  int textResult=result.availablePlanNumberFromText();
	  
	  Thread.sleep(7000);
	  //Reporter.log("Fetching number of results from Banners",true);
	  logger.info("Fetching number of results from Banners");
	  int bannerResult=result.availablePlanNumberFromBanners();
	  
	  Thread.sleep(1000);
	  Assert.assertEquals(textResult, bannerResult,"Text Results are not matching with Banner results,TC is failed");
	  
	  //Reporter.log("TC is Passed",true);
	  logger.info("TC is Passed");
	  Utility.takeScreenShot(driver, "CF_TC555");
	  
  }
   
  @AfterMethod
  public void closeBrowser() throws InterruptedException
  {
	  Thread.sleep(3000);
	  closeCoverFox();
  }
  
 
}
