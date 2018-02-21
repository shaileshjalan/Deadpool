package frontpage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility.capturescreenshot;
import utility.main;

public class hello {
@Test 
public void test(){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shree\\Desktop\\class\\seleniumchrome\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.oracle.com/index.html");
	 driver.manage().window().maximize();
	 ArrayList al=new ArrayList();
	 String n=read.test(0,0);
	 for( u=0;u<15;u++){
	  locatr=read.test(u,0);
	  al.add(locatr);
	 }
	 System.out.println(al);
	 for(i=1;i<al.size();i++){
	     exceldata=driver.findElement(By.xpath(".//a[Text()='"+al.get(i)+"']"));
	     exceldata.click();
		}	
}

