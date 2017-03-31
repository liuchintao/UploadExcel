package net.localstudy.excel.service.impl;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.localstudy.excel.exception.FileTypeException;
import net.localstudy.excel.exception.GettingTypeException;
import net.localstudy.excel.exception.UploadFileException;
import net.localstudy.excel.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * In this method, we will call dao layer method
	 * to implement the function that upload .xls file
	 * by transferring the rows of students to the 
	 * List of class userInfo.
	 * @throws IOException 
	 */
	public int uploadUserXls(MultipartFile file) 
			throws UploadFileException, IOException{
		if(!validateType(file))	return -1;
		HSSFWorkbook wb = null;
		wb = new HSSFWorkbook(file.getInputStream());
		HSSFSheet sheet = wb.getSheetAt(0);
		//for debug: show the name of sheet that we get
		logger.debug("sheet name = " + wb.getSheetAt(0));
		for(int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++){
			HSSFRow row = sheet.getRow(i);
			Iterator cells = row.cellIterator();	
			while(cells.hasNext()){
				HSSFCell cell = (HSSFCell) cells.next();
				logger.debug(cell.getStringCellValue());
			}
		}
		logger.debug("last row = " + sheet.getLastRowNum());
		return 0;
	}
	
	private boolean validateType(MultipartFile file){
		String fileType;
		try{
			//get MultipartFile original filename to validate file type.
			String fileName = file.getOriginalFilename();
			fileType = fileName.substring(fileName.indexOf('.') + 1,
					fileName.indexOf('.') + 4);
			if(fileType.isEmpty() || !fileType.toLowerCase().equals(".xls")){
				throw new FileTypeException("the file introduced is not .xls file.");
			}
		}catch(GettingTypeException e){
			logger.error("error occurs while getting file type.");
			return false;
		}catch(FileTypeException e){
			logger.error("the file introduced is not .xls file.");
			return false;
		}
		return true;
	}

}
