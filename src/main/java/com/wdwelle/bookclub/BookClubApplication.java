package com.wdwelle.bookclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


@SpringBootApplication
public class BookClubApplication {
	public LocalSessionFactoryBean sessionFactory() {
	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	return sessionFactory;
	}
	public static void main(String[] args) {
		SpringApplication.run(BookClubApplication.class, args);
	}

}
