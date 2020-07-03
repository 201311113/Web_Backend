package com.javalec.ex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


@Configuration
public class AdminConfig1 {
	@Value("${file1.id:@null}")
	private String adminId;
	@Value("${file1.nick}")
	private String adminPw;
	@Value("${file2.id}")
	private String sub_adminId;
	@Value("${file2.nick}")
	private String sub_adminPw;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer Pro() {
		PropertySourcesPlaceholderConfigurer con = new PropertySourcesPlaceholderConfigurer();
		
		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("file1.pro");
		locations[1] = new ClassPathResource("file2.pro");
		con.setLocations(locations);
		
		return con;
	}
	
	@Bean
	public AdminConnection adminConfig() {
		AdminConnection admincon = new AdminConnection();
		admincon.setAdminId(adminId);
		admincon.setAdminPw(adminPw);
		admincon.setSub_adminId(sub_adminId);
		admincon.setSub_adminPw(sub_adminPw);
		return admincon;
	}
}
