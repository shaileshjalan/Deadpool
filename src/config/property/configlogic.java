package config.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configlogic {
	public static Properties or;
	FileInputStream instream;
	
public  configlogic(){
	or=new Properties();
	File src=new File("C:\\Users\\shree\\Documents\\program\\adminlte\\src\\config\\property\\config.properties");
	try {
		instream=new FileInputStream(src);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		or.load(instream);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	
public String getbro(){
	String fire=or.getProperty("browsername");
	return fire;
}
public String geturl(){
	return or.getProperty("url");
	
}
}
