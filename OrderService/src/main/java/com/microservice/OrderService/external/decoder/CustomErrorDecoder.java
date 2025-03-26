package com.microservice.OrderService.external.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.OrderService.exception.CustomException;
import com.microservice.OrderService.external.response.ErrorResponse;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            ErrorResponse errorResponse = mapper.readValue(response.body().asInputStream(),ErrorResponse.class);

            return new CustomException(errorResponse.getErrorMessage(),
                    errorResponse.getErrorCode(),
                    response.status());
        } catch (IOException e) {
            throw new CustomException("Internal Server Error",
                    "INTERNAL_SERVER_ERROR",
                    500);
        }

    }
}
