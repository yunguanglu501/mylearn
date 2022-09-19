package com.example.learn.aop;

import cn.hutool.core.text.CharSequenceUtil;
import com.example.learn.exception.BusinessException;
import com.example.learn.util.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/28 17:26
 */
@Aspect
@Component
@Slf4j
public class SignAspect {

    /**
     * SIGN_HEADER.
     */
    private static final String SIGN_HEADER = "X-SIGN";

    /**
     * pointcut.
     */
    @Pointcut("execution(@com.example.learn.anno.Signature * *(..))")
    private void verifySignPointCut() {
        // nothing
    }

    /**
     * verify sign.
     */
    @Before("verifySignPointCut()")
    public void verify() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String sign = request.getHeader(SIGN_HEADER);
        // must have sign in header
        if (CharSequenceUtil.isBlank(sign)) {
            throw new BusinessException("no signature in header: " + SIGN_HEADER);
        }
        // check signature
        try {
            String generatedSign = SignUtil.generatedSignature(request);
            if (!sign.equals(generatedSign)) {
                throw new BusinessException("invalid signature");
            }
        } catch (Throwable throwable) {
            throw new BusinessException("invalid signature");
        }
    }
}
