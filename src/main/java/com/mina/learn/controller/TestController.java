package com.mina.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/test")
@CrossOrigin
@Api(tags = "用户登陆测试")
public class TestController {
	@ApiOperation(value = "测试登陆方法",  notes = "测试登陆方法")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(@ApiParam(required = true, name = "userName", value = "用户名") @RequestParam(required = true, value = "userName") String userName,
			@ApiParam(required = true, name = "password", value = "密码") @RequestParam(required = true, value = "password")String password){
		if(userName.equals("testUser") && password.equals("123456")){
			return "true";
		}else{
			return "false";
		}
	}
	
	@Value("${com.dudu.name}")
    private  String name;
    @Value("${com.dudu.want}")
    private  String want;
	
	
/*	@RequestMapping("/testapp")
	public String testapp(){
		return name+ "===="+want;
	}
	
    
    @Autowired
    ConfigBean configBean;
    
	@RequestMapping("/test")
	public String test(){
		return configBean.getName() + "===="+configBean.getSex();
	}*/
}
