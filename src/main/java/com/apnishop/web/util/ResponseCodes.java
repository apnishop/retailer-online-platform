package com.apnishop.web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@PropertySource(value={"classpath:messages.properties"})
@Component
public class ResponseCodes {
	
	
	public static String Code_2001;
	
	
	public static String Code_4001;
	
	public static String Code_4002;
	
	
	public static String Code_5001;
	
	public static String Code_5002;
	
	@Value("${2001}")
	public void setCode_2001(String val) {
		Code_2001 = val;
	}

	@Value("${4001}")
	public void setCode_4001(String code_4001) {
		Code_4001 = code_4001;
	}
	
	@Value("${4002}")
	public void setCode_4002(String code_4002) {
		Code_4002 = code_4002;
	}

	@Value("${5001}")
	public void setCode_5001(String code_5001) {
		Code_5001 = code_5001;
	}
	
	@Value("${5002}")
	public void setCode_5002(String code) {
		Code_5002 = code;
	}
	
	

}
