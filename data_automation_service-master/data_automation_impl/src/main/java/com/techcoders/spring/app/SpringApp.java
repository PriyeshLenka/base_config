package com.techcoders.spring.app;

import com.database_config.config.DatabaseConfigApplication;

import jakarta.ws.rs.ApplicationPath;

/**
 * The Class TrainingApp.
 * 
 * @author PRIYESH
 */
@ApplicationPath("/data_automation")
public class SpringApp extends DatabaseConfigApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		DatabaseConfigApplication.run(SpringApp.class, args);
	}
}