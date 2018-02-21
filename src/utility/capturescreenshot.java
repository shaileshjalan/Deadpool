package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class capturescreenshot {
public static String capturescreen(WebDriver driver ,String screenshotname){
	try {
		//TakesScreenshot take=(TakesScreenshot)driver;
	File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
  FileUtils.copyFile(source,new File("C:\\Users\\shree\\Documents\\program\\adminlte\\screenshots\\"+screenshotname+".png"));
  System.out.println("SCREEN SHORT TAKEN");
  
  return screenshotname;
} catch (Exception e) {
	System.out.println("excepastion is occurd"+e.getMessage());

	return e.getMessage();
}	
}

}
