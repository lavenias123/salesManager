package com.stewartlavenia.SalesManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stewartlavenia.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses={ComponentScanMarker.class})
public class SalesManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesManagerApplication.class, args);
	}

}
