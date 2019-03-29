package com.demo.ssjo.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 应用程序配置类
 *
 * @author lec
 */
@Component
@ConfigurationProperties(prefix = "cfg")
public class ApplicationConfig {

	/**文件上传下载——本地路径*/
	private String uploadPath;

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
}
