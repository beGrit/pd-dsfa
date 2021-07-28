package com.dsfa.nc;

import com.dsfa.platform.starter.meta.version.AbstractVersion;
import com.dsfa.platform.starter.meta.version.ProductVersion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author rm
 */
@SpringBootApplication(scanBasePackages = "com.dsfa")
public class DsfaProjectNcApplication {

	@Bean
	public AbstractVersion projectVersion(){
		return ProductVersion.newInstance();
	}

	public static void main(String[] args) {
		SpringApplication.run(DsfaProjectNcApplication.class, args);
	}

}
