package com.example.xiaochun.common.exception;

import com.example.xiaochun.common.api.ApiResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获自定义异常
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public ApiResult<Map<String,Object>> handle(ApiException e) {
        if(e.getErrorCode() != null) {
            return ApiResult.failed(e.getErrorCode());
        }
        return ApiResult.failed(e.getMessage());
    }
}
