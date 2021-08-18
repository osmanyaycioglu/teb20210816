package com.ee.training.rest.error;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintErrorHandler implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException exceptionParam) {
        ErrorObj errorObj = new ErrorObj().setMessage("Validasyon Hatası oluştu")
                                          .setCause(130);
        Set<ConstraintViolation<?>> constraintViolationsLoc = exceptionParam.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolationLoc : constraintViolationsLoc) {
            errorObj.add(new ErrorObj().setMessage(constraintViolationLoc.toString())
                                       .setCause(140));
        }
        return Response.status(400)
                       .header("Content-Type",
                               MediaType.APPLICATION_JSON)
                       .entity(errorObj)
                       .build();
    }

}
