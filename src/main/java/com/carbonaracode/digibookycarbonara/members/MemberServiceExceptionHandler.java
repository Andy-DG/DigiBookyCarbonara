package com.carbonaracode.digibookycarbonara.members;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Logger;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class MemberServiceExceptionHandler  {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(IllegalArgumentException exception, HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), exception.getMessage());
        logger.warning(exception.getMessage());
    }

}
