package com.techcoders.spring.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.database_config.config.SourceConfig;

/**
 * The Class DarkDBConfig.
 */
@Configuration
public class DarkDBConfig extends SourceConfig {

	/** The Constant DB. */
	private static final String DB = "darkdb";

	/** The Constant DARKDB_PU. */
	public static final String DARKDB_PU = "DARKDB_PU";

	/** The Constant DARKDB_TXN. */
	public static final String DARKDB_TXN = "DARKDB_TXN";

	/** The Constant ENTITY_SCAN. */
	private static final String ENTITY_SCAN = "com.techcoders.spring.entity";

	/**
	 * Instantiates a new dark DB config.
	 */
	public DarkDBConfig() {
		super(DB, ENTITY_SCAN, DARKDB_PU, DARKDB_TXN);
	}

	/**
	 * Creates the dark db beans.
	 *
	 * @return the bean factory post processor
	 */
	@Bean
	public BeanFactoryPostProcessor createDarkDbBeans() {
		return createPersistenceBeans();
	}
}