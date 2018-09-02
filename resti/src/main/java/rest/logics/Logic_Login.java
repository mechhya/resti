package rest.logics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.beans.Bean_login;
import rest.services.dao.DAO_LOGIN;
import rest.services.dto.UserDto;

@Service
public class Logic_Login {
	@Autowired
	private DAO_LOGIN dao_login;
	public boolean login(Bean_login bean_login) {
		UserDto userInfoReq = new UserDto();
		UserDto UserDtoRes = new UserDto();
		userInfoReq.setId(bean_login.getId());
		try {
			UserDtoRes = dao_login.getuserinfo(userInfoReq);
			if(UserDtoRes!= null) {
				//TODO more complex Decision
				return (UserDtoRes.getId() == bean_login.getId())?true:false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
