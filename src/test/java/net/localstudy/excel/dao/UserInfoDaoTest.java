package net.localstudy.excel.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.localstudy.excel.entity.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserInfoDaoTest {
	
	@Autowired
	private UserInfoDao userInfoDao;

	@Test
	public void testUploadUserInfo() {
		List<UserInfo> userList = new ArrayList<UserInfo>();
		UserInfo user;
		for(int i = 0; i < 10; i++){
			user = new UserInfo();
			userList.add(user);
			user.setStuNum(i);
			user.setStuGroup(i%2);
			user.setStuScore(100-i);
		}
		int uploadCount = userInfoDao.uploadUserInfo(userList);
		System.out.println("this commit has influenced " + uploadCount + " line(s).");
	}

}
