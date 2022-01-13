package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/")
public class Log4jTestApplication {
	private static Logger logger = LogManager.getLogger(Log4jTestApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(Log4jTestApplication.class, args);
	}

	@RequestMapping("index")
	@ResponseBody
	public String index() {
		return "Hello,我是simon";
	}


	/**
	 * 测试log4j漏洞
	 * @param
	 * @return String 提示信息
	 * @author zhangxue9
	 * @date 2021/12/30 11:00
	 */
	@RequestMapping("testlog4j")
	@ResponseBody
	public String testlog4j(){
		logger.info("正常======================日志1");
		logger.info("${jndi:ldap://127.0.0.1:8080}");//模拟访问ldap服务器,如果被注入则会访问ldap服务器,如果没有则会打印出字符串
		logger.info("正常======================日志2");
		return "控制台查看第二行执行了代码，并未直接打印${jndi:ldap://127.0.0.1:8080}";
	}


}
