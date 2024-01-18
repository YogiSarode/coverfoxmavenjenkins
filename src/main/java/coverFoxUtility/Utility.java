package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
	public static String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
	{
		Reporter.log("Reading data from excelsheet", true);
		FileInputStream myfile=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\CoverFoxdetails.xlsx");
		Sheet mySheet=WorkbookFactory.create(myfile).getSheet("CoverFoxData");
		String data=mySheet.getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	public static void takeScreenShot(WebDriver driver, String TCID) throws IOException 
	{
		Reporter.log("Taking ScreenShot",true);
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest =new File("C:\\Users\\HP\\OneDrive\\Desktop\\selenium\\MyScreenshots\\coverFox"+TCID+"_"+timeStamp+".png");
		Reporter.log("Saved ScreenShot at"+dest, true);
		FileHandler.copy(src, dest);
		
	}
	public static String readDataFromPropertiesFile(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream myfile=new FileInputStream(System.getProperty("user.dir")+"\\CoverFoxDetails.properties");
		prop.load(myfile);
		
		String value=prop.getProperty(key);
		return value;
		
	}
		
	

}
