package com.springpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class,
		JdbcTemplateAutoConfiguration.class
})
public class SpringPoolExampleApplication implements CommandLineRunner {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringPoolExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList("SELECT * FROM empapp.employee_db");
		queryForList.forEach((item) -> {
			System.out.println("foreach running");
			System.out.println("id : " + item.get("id"));
			System.out.println("name : " + item.get("name"));
			System.out.println("phone : " + item.get("phone"));
			System.out.println("--------------------------");
		});


//		jdbcTemplate.update("update empapp.employee_db set name = 'Arun' where id=6");
//		System.out.println("updated");


	}
}
