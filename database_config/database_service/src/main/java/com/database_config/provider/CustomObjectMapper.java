package com.database_config.provider;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CustomObjectMapper implements ContextResolver<ObjectMapper> {

	@Override
	public ObjectMapper getContext(final Class<?> type) {
		return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)
				.configure(SerializationFeature.WRAP_ROOT_VALUE, Boolean.TRUE)
				.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, Boolean.TRUE);
	}

}
