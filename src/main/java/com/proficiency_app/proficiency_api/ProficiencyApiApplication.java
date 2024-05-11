package com.proficiency_app.proficiency_api;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProficiencyApiApplication {

	public static void main(String[] args) throws IOException {
		/*
		 * FirebaseApp.initializeApp();
		 * FileInputStream refreshToken = new
		 * FileInputStream("/resources/refreshToken.json");
		 * FirebaseOptions options = FirebaseOptions.builder()
		 * .setCredentials(GoogleCredentials.fromStream(refreshToken))
		 * .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
		 * .build();
		 */
		SpringApplication.run(ProficiencyApiApplication.class, args);
	}

}
