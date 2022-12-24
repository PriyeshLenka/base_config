package com.database_config.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import com.database_config.annotation.Init;
import com.database_config.helper.Constants;
import com.database_config.provider.CustomObjectMapper;

public class JersyConfig extends ResourceConfig{

	public JersyConfig() {
		registerEndpoints();
	}
	
	private void registerEndpoints() {
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(
				Boolean.FALSE);

		scanner.addIncludeFilter(new AnnotationTypeFilter(Init.class));

		for (BeanDefinition bd : scanner.findCandidateComponents(Constants.BASE_PACKAGE)) {
			try {
				Class<?> loadedClass = getClass().getClassLoader().loadClass(bd.getBeanClassName());
				register(loadedClass);
//				packages("com.xcvbnm");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		register(JacksonFeature.class);
		register(CustomObjectMapper.class);
	}
}
