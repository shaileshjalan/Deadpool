package frontpage;
import static org.testng.Assert.assertEquals;
import static config.property.configlogic.*;
import static frontpage.methods.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.jdt.internal.compiler.ast.ArrayQualifiedTypeReference;
import org.omg.CORBA.LocalObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import config.property.configlogic;
import utility.capturescreenshot;
import utility.capturescreenshot.*;
import utility.result;



public class LoginPageTest {
	String loctype;
	String idpath;
	String chromeb;
	String udata;
	String pass;
	String pdata;
	String submit;
	String [] locat =new String[15];
	String [] hl=null; 
	String menu_item;
	 String locator;
	//WebDriver driver;
	 ArrayList<String> menu=new ArrayList<String>();
	 List<WebElement> radio1;
	configlogic logic=new configlogic();
	String m;
int i;
ExtentReports repo;
ExtentTest logger;

		String sheetname="login";
		String path="C:\\Users\\shree\\Desktop\\framwork.xlsx";
		readexcel read=new readexcel(path,sheetname);
		methods meth=new methods();
		result res=new result();
		 String s;
		
public  LoginPageTest(){
	repo=new ExtentReports("C:\\Users\\shree\\Documents\\program\\adminlte\\ssreports\\login.html", true);
	
}
		
@Test(priority=1)
public void getbrowser(){
logger=repo.startTest("Test First");
 //loctype=read.readExecl(2,3);	
// chromeb=read.readExecl(2,4);
// meth.getbrowser(chromeb);
 meth.getbrowser(logic.getbro());
 logger.log(LogStatus.PASS,"browser is up");

}
@Test(priority=2)
public void enter_url(){	
	logger=repo.startTest("TEST SECOND");
//loctype=read.readExecl(3,3);	
meth.enter_url(logic.geturl());
//String url=read.readExecl(3,5);
//meth.enter_url(url);	
logger.log(LogStatus.PASS, "Enter details");
}
	
@Test(priority=3)
public void loginwith_invalidata(){	
logger=repo.startTest("Thrid Test");
	
    loctype=read.readExecl(4,3);
	idpath=read.readExecl(4,4);
	udata=read.readExecl(4,5);
	meth.enter_text(loctype, idpath, udata);
	 loctype=read.readExecl(5,3);
	 pass=read.readExecl(5,4);
    pdata=read.readExecl(5,5);
    meth.enter_text(loctype, pass, pdata);
    submit=read.readExecl(9,4);
    meth.click(submit);
  String s= capturescreenshot.capturescreen(driver, "invalid");
  String p=logger.addScreenCapture(s);
    logger.log(LogStatus.FAIL,p);
}
	

@Test(priority=4)	
public void loginwith_validata(){
	logger=repo.startTest("TEST FOURTH");
	loctype=read.readExecl(4,3);
idpath=read.readExecl(6,4); 
   udata=read.readExecl(6,5);
meth.enter_text(loctype, idpath, udata);

    pass=read.readExecl(7,4);
	pdata=read.readExecl(7,5);
	meth.enter_text(loctype, pass, pdata);
 meth.click(submit);
 logger.log(LogStatus.PASS, "valid data is entered");
} 
@Test(priority=5)
public void linkcheck(){
	logger=repo.startTest("TEST Fifth");
	for(int i=11;i<15;i++)
	{

		locat[i]=read.readExecl(i,4);
		meth.click(locat[i]);
		
		if(locat[i].equals(read.readExecl(i,3))){
		System.out.println("FAIL");
		}else 
			System.out.println("PASS");
		logger.log(LogStatus.PASS, "linkcheck");
	}
}
@Test(priority=6)
public void menu(){
	logger=repo.startTest("TEST SIXTH");
	 ArrayList menu=new ArrayList();
   loctype=read.readExecl(16,3);
    locator=read.readExecl(16,4);
    for(int i=16;i<=20;i++)
    { 
  	 s=read.readExecl(i,5);
  	   menu.add(s);
    }
    ArrayList returnmenu=new ArrayList();
	  WebElement data=driver.findElement(By.xpath("//ul[@class='sidebar-menu']"));
	   	List<WebElement>li = data.findElements(By.tagName("li"));
	   	int data1=li.size();
	   	System.out.println("total number od size"+data1);
	   	hl=new String[data1];
	   	for(int j=0;j<data1;j++){
	   	hl[j]=li.get(j).getText();
	   	for(WebElement we1:li){
	   m=we1.getText();
	   		System.out.println(m);
	   		returnmenu.add(m);
	   	}
   	if(returnmenu.get(j).equals(m)==menu.get(i).equals(s))
   		System.out.println("menu is match"+returnmenu.get(j));
   		else
   			System.out.println("menu is not match"+menu.get(i));
   	}
   		
   	}
    @Test(priority=7) 	
	public void adduser(){
   loginwith_validata();
locator=read.readExecl(21,4);
meth.click(locator);
locator=read.readExecl(22,4);
meth.click(locator);
logger.log(LogStatus.PASS, "add the page");
    }
 @Test(priority=8)
public void enterdata(){
	 logger=repo.startTest("NINETH Test");
	 for(int i=23;i<26;i++){
		 locator=read.readExecl(i,4);
		 udata=read.readExecl(i,5);
		 meth.adduser(locator,udata);
		 logger.log(LogStatus.PASS, "enter the data");
	 }
 }
 @Test(priority=9)
public void button(){
	 logger=repo.startTest("tenth Test");
locator=read.readExecl(26,4);
udata=read.readExecl(26, 5);
meth.radiobutton(locator, udata);
}
 @Test(priority=10)
 public void drop(){
	 logger=repo.startTest("dropdown text");
	 locator=read.readExecl(27,4);
	 udata=read.readExecl(27,5);
	 meth.dropdown(locator, udata);
	 locator=read.readExecl(28,4);
	 udata=read.readExecl(28, 5);
	 meth.enterdata(locator, udata);
     locator=read.readExecl(29,4);
     meth.click(locator);
     logger.log(LogStatus.PASS, "dropdown");
     
 }
 @Test(priority=11)
 public void pop(){
	 logger=repo.startTest("eleventh report");
	 meth.alertpop();
	 logger.log(LogStatus.PASS, "HANDLING POPUP");
 }
 @Test(priority=12)
 public void end(){
	 logger=repo.startTest("end of the page");
	 String end1=read.readExecl(30,4);
	 meth.click(end1);
	 logger.log(LogStatus.PASS,"end of the testcase");
      repo.endTest(logger);
	    repo.flush();	
	    
 	
 }
 
	 }
	 
 
 
 
 
 
 

	
 

	









		
	


