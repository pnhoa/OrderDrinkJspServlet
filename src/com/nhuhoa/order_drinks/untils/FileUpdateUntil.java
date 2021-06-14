package com.nhuhoa.order_drinks.untils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class FileUpdateUntil {
private static final String  UPLOAD_DIR = "resource"+ File.separator +"images"+ File.separator;
	
	@SuppressWarnings("resource")
	public static String saveImage(HttpServletRequest request) {
		String result = "";
		try {
			String applicationPath = request.getServletContext().getRealPath("");
			Part filePart = request.getPart("image");
			
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		    String filePath = applicationPath + File.separator + UPLOAD_DIR + File.separator + fileName;
		    System.out.println(filePath);
	        InputStream inputStream = null;
	        OutputStream outputStream = null;
        
	        File outputFilePath = new  File(filePath);
	        inputStream = filePart.getInputStream();
	        outputStream = new FileOutputStream(outputFilePath);
	        int read = 0;
	        final byte[] bytes =  new  byte[1024];
	        while((read = inputStream.read(bytes)) != -1){
	            outputStream.write(bytes, 0, read);
	        }
	        
	        result = UPLOAD_DIR + File.separator + fileName;
	        System.out.println(result);
        }catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
