package net.localstudy.excel.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.localstudy.excel.exception.UploadFileException;
import net.localstudy.excel.service.UserInfoService;

/**
 * 1st version without any transaction management
 * and sql execution stateInfo or warn.
 * 2017-3-31
 * @author Magister
 *
 */
@Controller
public class UploadXlsController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/start")
	public String start(){
		return "upload";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(@RequestParam("xlsfile") MultipartFile file){
		try {
			int uploadCount = userInfoService.uploadUserXls(file);
			System.out.println("upload lines: " + uploadCount);
			if(uploadCount > 0){
				return "success";
			}
		} catch (UploadFileException e) {
			logger.error("error occurs while getting file type.");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("error occurs while transfering file");
			e.printStackTrace();
		}
		return "redirect:excels/start"; 
	}
}
