package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoverFoxMemberDetailsPage 
{
	 @FindBy(id="Age-You") private WebElement ageDropDown;
	    @FindBy(className="next-btn") private WebElement nextButtonOnMemberDetailPage;
	    
	    public CoverFoxMemberDetailsPage(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    }
	    
	    public void handledAgeDropDown(String age)
	    {
	    	Select s=new Select(ageDropDown);
	    	s.selectByValue(age+"y");
	    	//ageDropDown.sendKeys("37");
	    }
	    
	    public void clickOnnextButtonOnDetailPage()
	    {
	    	nextButtonOnMemberDetailPage.click();
	    }
}
