package com.rajneesh.eshop.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	private static final String ABS_PATH = "E:\\Demo_Project_2020\\E-Shop\\eshop\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest req, MultipartFile file, String code) {
		REAL_PATH = req.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info(REAL_PATH);
		
		//To make sure all directory exits
		// Create new directory
		if(!new File(ABS_PATH).exists()) {
			// create new directory
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists()) {
			// create new directory
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			// Upload to Server
			file.transferTo(new File(REAL_PATH + code +".jpg"));
			
			// Upload to Server
			file.transferTo(new File(ABS_PATH + code +".jpg"));			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
