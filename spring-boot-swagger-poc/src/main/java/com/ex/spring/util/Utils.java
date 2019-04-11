package com.ex.spring.util;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class Utils {
	
	public static Response wrapResponse(Object object) {
		if (object instanceof com.ex.spring.rest.exception.Error) {
			return Response.status(((com.ex.spring.rest.exception.Error) object).getErrorCode()).entity(object).build();
		} else {
			return Response.status(Status.OK).entity(object).build();
		}
	}

}
