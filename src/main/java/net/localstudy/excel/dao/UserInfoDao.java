package net.localstudy.excel.dao;

import java.util.List;

import net.localstudy.excel.entity.UserInfo;

/**
 * now I just want to implement the function
 * that upload .xls file to database.
 * 2017-3-31
 * @author Magister
 *
 */
public interface UserInfoDao {
	/**
	 * the method uploads the set of userInfo
	 * @param userInfo
	 * @return insert count number.
	 */
	public int uploadUserInfo(List<UserInfo> userList);
}
