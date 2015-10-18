package com.smart.fridge.exception;

import com.smart.fridge.controller.CustomResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Component
public final class CustomExceptionHandler implements
        ExceptionMapper<Exception> {

    @Autowired
    private CustomResponseBuilder customResponseBuilder;

    /**
     * Pack any unhandled exception into ErrorMessage
     *
     * @param exception unhandled exception
     * @return response with response code 400 and exception message
     */
    @Override
    public Response toResponse(final Exception exception) {
        return customResponseBuilder.buildCustomResponse(Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorMessage(exception.getMessage())
                ).type(MediaType.APPLICATION_JSON).build());
    }
}
