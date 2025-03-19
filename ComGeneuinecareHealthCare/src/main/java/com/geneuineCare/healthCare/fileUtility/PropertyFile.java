package com.geneuineCare.healthCare.fileUtility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class PropertyFile {
	public String getDatafromProperty(String value) throws IOException {
		FileInputStream fis = new FileInputStream("./configData/commonData1.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(value);
		return data;

	}
}
