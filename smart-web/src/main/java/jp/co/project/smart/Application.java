package jp.co.project.smart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.project.smart", "jp.co.project.smart" })
@MapperScan({ "jp.co.project.smart.autogen.mapper", "jp.co.project.smart.mapper" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
