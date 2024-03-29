package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener
{
    @Override
    public void onTestSuccess(ITestResult result)
    {
	  String TCName=result.getName();
	  Reporter.log("TC "+TCName+ " is completed successfully",true);
    }
    
    @Override
    public void onTestSkipped(ITestResult result)
    {
	  String TCName=result.getName();
	  Reporter.log("TC "+TCName+ " is Skipped please check dependent method",true);
    }
    
    @Override
    public void onTestFailure(ITestResult result)
    {
	  String TCName=result.getName();
	  Reporter.log("TC "+TCName+ " is Failed,please check again",true);
    }
    
    @Override
    public void onTestStart(ITestResult result)
    {
	  //String TCName=result.getName();
	  Reporter.log("TC "+result.getName()+ " execution is started",true);
    }

}
