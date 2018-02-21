package frontpage;


import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static config.property.configlogic.*;

import org.omg.CORBA.LocalObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;

import config.property.configlogic;


public class methods  {
public static WebDriver driver;
WebElement we;
ArrayList<String> returnmenu=new ArrayList<String>();
ArrayList<String> menu=new ArrayList<String>();
List<WebElement> radio1;
configlogic logic=new configlogic();

public void getbrowser(String browsername){
	logic.getbro();
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shree\\Desktop\\class\\seleniumchrome\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	
}
public void enter_url(String values){
	driver.get(logic.geturl());
}


public void enter_text(String locatortype, String locator,String values) 
{
	we=null;
	if(locatortype.equalsIgnoreCase("xpath")) { 
	 
		we=driver.findElement(By.xpath(locator));

	}else if(locatortype.equalsIgnoreCase("xpath")){
		
		we=driver.findElement(By.xpath(locator));
		}
	    we.clear();
		we.sendKeys(values);
	}


public void menu_count(String locatortype,String locator )
{

}


public void adduser(String locator, String data){
	driver.findElement(By.xpath(locator)).sendKeys(data);
}
public void radiobutton(String locator,String value){
 radio1=driver.findElements(By.xpath(locator));
for(int i=0;i<1;i++){
WebElement radio=radio1.get(i);
String button=radio.getAttribute("value");
if(button.equals(value)){
	radio.click();
}

}
}
public void dropdown(String locator,String value){
we=driver.findElement(By.xpath(locator));
Select sl=new Select(we);
List<WebElement>li=sl.getOptions();
for(int i=0;i<li.size();i++){
	WebElement opstion=li.get(i);
	String opstionlist =opstion.getText();
	if(opstionlist.equalsIgnoreCase(value)){
		System.out.println(opstionlist);
		opstion.click();
	}else if(value==""){
		driver.findElement(By.xpath(locator)).click();
	}	
}
}
public void enterdata(String locator,String value){
	driver.findElement(By.xpath(locator)).sendKeys(value);
	driver.findElement(By.xpath(locator)).click();
}

public void alertpop(){
	
		Alert al=driver.switchTo().alert();
		al.getText();
		al.accept();	
}

public void click(String locator) {
	
	WebElement clk=driver.findElement(By.xpath(locator));
	clk.click();
	}



}

	
	




	
	
	


