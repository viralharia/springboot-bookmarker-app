package com.vharia.bookmarker_api;

import org.springframework.boot.SpringApplication;

public class TestBookmarkerApiApplication {

	public static void main(String[] args) {
		//SpringApplication.from(BookmarkerApiApplication::main).with(TestcontainersConfiguration.class).run(args);
		SpringApplication.from(BookmarkerApiApplication::main).run(args);
	}

}
