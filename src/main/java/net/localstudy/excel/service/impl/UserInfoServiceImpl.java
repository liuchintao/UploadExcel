package net.localstudy.excel.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.localstudy.excel.dao.UserInfoDao;
import net.localstudy.excel.entity.UserInfo;
import net.localstudy.excel.exception.FileTypeException;
import net.localstudy.excel.exception.GettingTypeException;
import net.localstudy.excel.exception.UploadFileException;
import net.localstudy.excel.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserInfoDao userInfoDao;
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
		List<UserInfo> userList = new ArrayList<UserInfo>();
		UserInfo user = null;
		Workbook book = null;
		try{
			book = new XSSFWorkbook(file.getInputStream());
		}catch(Exception e){
			book = new HSSFWorkbook(file.getInputStream());
		}
		Sheet sheet = book.getSheetAt(0);
		//for debug: show the name of sheet that we get
//		logger.debug("sheet name = " + book.getSheetAt(0));
		for(int i = sheet.getFirstRowNum()+1; i <= sheet.getLastRowNum(); i++){
			user = new UserInfo();
			userList.add(user);
			Row row = sheet.getRow(i);
			user.setStuId((long)row.getCell(0).getNumericCellValue());
			user.setStuGroup((int)row.getCell(1).getNumericCellValue());
			user.setStuScore(row.getCell(2).getNumericCellValue());
//			Iterator<Cell> cells = row.cellIterator();	
//			while(cells.hasNext()){
//				//TODO modify this function by append method "getCellValueType()
//				//now this function is so stupid.
//				Cell cell = cells.next();
//				if(i>0){
//					logger.debug(String.valueOf(cell.getNumericCellValue()));		
//				}else{
//					logger.debug(cell.getStringCellValue());
//				}
//			}
		}
		if(!userList.isEmpty()){
			return userInfoDao.uploadUserInfo(userList);
		}
//		logger.debug("last row = " + sheet.getLastRowNum());
		return 0;
	}
	
	private boolean validateType(MultipartFile file){
		String fileType;
		try{
			//get MultipartFile original filename to validate file type.
			String fileName = file.getOriginalFilename();
			fileType = fileName.substring(fileName.lastIndexOf('.'),
					fileName.lastIndexOf('s') + 1);
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
