package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rest.beans.Bean_login;
import rest.logics.Logic_Login;
@RestController
public class Ctrl_login {
	@Autowired
	private Logic_Login logic_login;
	@RequestMapping("/login")
	public boolean loginProcess(@RequestParam(required=true,defaultValue="0") Integer id) {
		 //TODO retrive encodeuserName and encoded Password
		Bean_login loginInfo = new Bean_login();
    	loginInfo.setId(id);
    	return logic_login.login(loginInfo);
	}

}
