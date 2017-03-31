package net.localstudy.excel.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.localstudy.excel.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	/**
	 * In this method, we will call dao layer method
	 * to implement the function that upload .xls file
	 * by transferring the rows of students to the 
	 * List of class userInfo.
	 */
	public int uploadUserXls(MultipartFile file) {
		
		return 0;
	}

}
