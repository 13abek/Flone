package com.Flone.Flone;

import com.Flone.Flone.core.utilities.fileManager.fileProperty.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.swing.text.html.parser.Entity;

@EnableSwagger2
@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class FloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(FloneApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.Flone.Flone"))
				.build();
	}

}

