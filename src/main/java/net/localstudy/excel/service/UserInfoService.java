package net.localstudy.excel.service;

import org.springframework.web.multipart.MultipartFile;

public interface UserInfoService {
	
	/**
	 * 
	 * @param file, which got from controller
	 * @return the number of lines impacted by sql.
	 */
	public int uploadUserXls(MultipartFile file);
}
