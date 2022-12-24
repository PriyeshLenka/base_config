package com.database_config.provider;

import com.database_config.helper.Constants;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class CustomExceptions implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		if (exception instanceof NotFoundException) {
			return Response.status(Response.Status.NOT_FOUND).entity(Constants.ENDPOINT_NOT_FOUND).build();
		} else if (exception instanceof NotSupportedException) {
			return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).entity(Constants.PAYLOAD_EXCEPTION).build();
		} else if (exception instanceof NotAllowedException) {
			return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity(Constants.METHOD_NOT_SUPPORTED).build();
		}
		return Response.serverError().entity(Constants.WRONG_MSG).build();
	}

}
