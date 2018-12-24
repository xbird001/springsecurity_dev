package com.xbird.web.controller;

import com.xbird.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.HashMap;
import java.util.Map;

/**
 * 当增强的具体方法出现异常将进入该方法
 */
@ControllerAdvice
public class ControllerExcepitonHandlerAdvice {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handerUserNotExistException(UserNotExistException exception) {
        System.out.println("进入advice");
        Map<String,Object> rs = new HashMap();
        rs.put("id",exception.getId());
        rs.put("mes",exception.getMessage());
        return rs;
    }
}
