package com.smart.fridge.controller;

import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class CustomResponseBuilder {
    public Response buildCustomResponse(Response response) {
        return Response.fromResponse(response).header("Access-Control-Allow-Origin", "*").build();
    }
}
