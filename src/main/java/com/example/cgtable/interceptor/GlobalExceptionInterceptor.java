package com.example.cgtable.interceptor;

import com.example.cgtable.common.CommonResult;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionInterceptor {
    @ExceptionHandler(Exception.class)
    public CommonResult exceptionhandle(Exception exception){
        String message = exception.getMessage();

        return CommonResult.fail().message(message);

    }
}
