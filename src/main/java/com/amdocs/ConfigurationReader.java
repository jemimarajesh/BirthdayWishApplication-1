package com.amdocs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/config.properties")
public class ConfigurationReader {
	
	@Value("${admin.name}")
	private String adminName;
	
	public String getAdminName() {
		return adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public String getExcelFilePath() {
		return excelFilePath;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public int getProxyPort() {
		return proxyPort;
	}

	public String getPhpHostUrl() {
		return phpHostUrl;
	}

	@Value("${admin.email}")
	private String adminEmail;
	
	@Value("${excel.file.path}")
	private String excelFilePath;
	
	@Value("${proxy.host}")
	private String proxyHost;
	
	@Value("${proxy.port}")
	private int proxyPort;
	
	@Value("${php.host.url}")
	private String phpHostUrl;

}
