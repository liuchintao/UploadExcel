package net.localstudy.excel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.localstudy.excel.service.UserInfoService;

@Controller
public class UploadXlsController {
	
	@Autowired
	private UserInfoService userInfoSvice;
	
	@RequestMapping("/upload")
	public String upload(HttpServletRequest req){
		
		return "success";
	}
}
