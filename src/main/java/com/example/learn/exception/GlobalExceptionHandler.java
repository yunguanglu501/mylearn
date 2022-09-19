package com.example.learn.exception;

import com.example.learn.common.DefaultErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/15 10:31
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends BaseGlobalExceptionHandler{

    /** 处理400类异常 */
    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public DefaultErrorResult handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
        return super.handleConstraintViolationException(e, request);
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public DefaultErrorResult handleConstraintViolationException(HttpMessageNotReadableException e, HttpServletRequest request) {
        return super.handleConstraintViolationException(e, request);
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public DefaultErrorResult handleBindException(BindException e, HttpServletRequest request) {
        return super.handleBindException(e, request);
    }

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public DefaultErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        return super.handleMethodArgumentNotValidException(e, request);
    }

    /** 处理自定义异常 */
    @Override
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<DefaultErrorResult> handleBusinessException(BusinessException e, HttpServletRequest request) {
        return super.handleBusinessException(e, request);
    }

    /** 处理运行时异常 */
    @Override
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public DefaultErrorResult handleThrowable(Throwable e, HttpServletRequest request) {
        //TODO 可通过邮件、微信公众号等方式发送信息至开发人员、记录存档等操作
        return super.handleThrowable(e, request);
    }


}
