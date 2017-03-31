package net.localstudy.excel.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import net.localstudy.excel.exception.UploadFileException;

public interface UserInfoService {
	
	/**
	 * 
	 * @param file, which got from controller
	 * @return the number of lines impacted by sql.
	 * @throws IOException 
	 * @throws UploadFileException 
	 */
	public int uploadUserXls(MultipartFile file) throws UploadFileException, IOException;
}
