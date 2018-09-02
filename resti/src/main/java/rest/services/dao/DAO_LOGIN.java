package rest.services.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import rest.services.config.ParentDao;
import rest.services.dto.UserDto;
import rest.services.utils.SQL_CONST;
@Repository
public class DAO_LOGIN {
	@Autowired
	private ParentDao parentDao;
	
	public UserDto getuserinfo(UserDto user) throws Exception{
      return parentDao.selectOne(SQL_CONST.LOGIN_00_00.S01,user);
	}
}
