package com.spring.boot;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(basePackages = "com.spring")
@EntityScan( basePackages = {"com.spring"} )
public class RetailMgtApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		/* SpringApplication.run(RetailMgtApplication.class, args); */
		SpringApplication app = new SpringApplication(RetailMgtApplication.class);
		app.setBanner(new Banner() {
			
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				out.print("\n\n\t"
						+ "  _____         __               __                         \r\n"
						+ " / ___/_ _____ / /____  __ _    / /  ___ ____  ___  ___ ____\r\n"
						+ "/ /__/ // (_-</ __/ _ \\/  ' \\  / _ \\/ _ `/ _ \\/ _ \\/ -_) __/\r\n"
						+ "\\___/\\_,_/___/\\__/\\___/_/_/_/ /_.__/\\_,_/_//_/_//_/\\__/_/   \r\n"
						+ "                                                            "
						+ "\n\n".toString());
				
			}
		});
		app.run(args);
		
		
	}

}
