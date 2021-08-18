package com.ee.training.rest.error;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalArgHandler implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(final IllegalArgumentException exceptionParam) {
        return Response.status(400)
                       .header("Content-Type",
                               MediaType.APPLICATION_JSON)
                       .entity(new ErrorObj().setMessage(exceptionParam.getMessage())
                                             .setCause(120))
                       .build();
    }

}
