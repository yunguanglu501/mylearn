package com.example.learn.aop;

import com.example.learn.common.*;
import com.example.learn.exception.BaseErrorCode;
import com.example.learn.exception.BaseException;
import com.example.learn.exception.BaseException2;
import com.example.learn.exception.BizErrorCode;
import com.example.learn.util.AssertUtil;
import com.example.learn.util.DealExceptionUtil;
import com.example.learn.util.TraceUtil;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;


/**
 * 切面
 */
//@Aspect
@Component
@Slf4j
public class ServiceAspect {

    /**
     * 切入点定义
     */
    @Pointcut("execution(* com.example.learn.service.impl.*.*(*))")
    public void pointCut() {
    }

    /**
     * 切面处理
     *
     * @param joinPoint joinPoint
     * @return 结果
     */
    @Around(value = "pointCut()")
    public Object control(ProceedingJoinPoint joinPoint) {
        Result<?> result;
        long startMilliSeconds = System.currentTimeMillis();
        // 类名
        String className = joinPoint.getTarget().getClass().getSimpleName();
        // 方法名
        String methodName = joinPoint.getSignature().getName();
        // 参数
        Object[] args = joinPoint.getArgs();
        try {
            // 1、校验
//            AssertUtil.checkNotNull(args[0], BizErrorCode.PARAMETER_VALID_ERROR, "Request must be not null");
            setTraceLogId(args);
            // 2、方法调用前记录日志
            log.info("call [{}] [{}] PARAMETER:[{}]", className, methodName, args);
//            AssertUtil.validateObject(args[0]);
//            if (args[0] instanceof PageDTO) {
//                AssertUtil.validateObject(((PageDTO<?>) args[0]).getReq());
//            }
            // 3、业务处理
            result = (Result<?>) joinPoint.proceed();
            // 4、方法调用后记录日志
            log.info("call [{}] [{}] [{}ms] [{}] [{}] RESPONSE:{}",
                    className, methodName, getTime(startMilliSeconds), getStatus(result), getResultCode(result), result);
            setCallTraceId(result);
        }catch (BaseException e) {
            //异常处理
//            log.error("service {},invoke throw PointCenterException with:{}",methodName,e);
            Result error = Result.ofFail(e.getStatus()+"", e.getMessage());
            error.setCallId(MDC.get(FrameworkConstant.TRACE_ID));
            return error;
        }catch (BaseException2 e) {
            //异常处理
//          log.error("service {},invoke throw PointCenterException with:{}",methodName,e);
            Result error = Result.ofFail(e.getErrorCode()+"", e.getMessage());
            error.setCallId(MDC.get(FrameworkConstant.TRACE_ID));
            return error;
        } catch (Exception e) {
            //异常处理
            log.error("service {},invoke error with:{}",methodName,e);
            Result error = Result.ofFail(BaseErrorCode.SYSTEM_INNER_ERROR.getStatus()+"", BaseErrorCode.SYSTEM_INNER_ERROR.getMessage());
            error.setCallId(MDC.get(FrameworkConstant.TRACE_ID));
            return error;
        } catch (Throwable e) {
            result = DealExceptionUtil.doExceptionService(e);
            log.info("result:[{}]", result);
            log.info("call [{}] [{}] [{}ms] EXCEPTION:Cause[{}]",
                    className, methodName, getTime(startMilliSeconds), Throwables.getStackTraceAsString(e));
            setCallTraceId(result);
        } finally {
            TraceUtil.clear();
        }
        return result;
    }

    /**
     * 获取耗时
     *
     * @param startTime 开始时间
     * @return 耗时，单位毫秒
     */
    private long getTime(long startTime) {
        return System.currentTimeMillis() - startTime;
    }

    private static String getStatus(Result<?> result) {
        return result.isSuccess() ? BizConstant.SUCCESS : BizConstant.FAIL;
    }

    private static String getResultCode(Result<?> result) {
        return result.isSuccess() ? "0000" : result.getErrorCode();
    }

    private void setTraceLogId(Object[] object) {
        try {
            if (object[0] instanceof BaseReq) {
                TraceUtil.put(((BaseReq) object[0]).getTraceId());
            } else if (object[0] instanceof PageDTO) {
                PageDTO pageDTO = (PageDTO) object[0];
                if (pageDTO.getReq() instanceof BaseReq) {
                    BaseReq req = (BaseReq) pageDTO.getReq();
                    if (req == null) {
                        TraceUtil.put();
                        return;
                    }
                    TraceUtil.put(req.getTraceId());
                } else {
                    TraceUtil.put();
                }
            } else {
                TraceUtil.put();
            }
        } catch (Exception e) {
            log.error("设置日志id异常：", e);
        }
    }

    private void setCallTraceId(Result result) {
        try {
            if (result != null) {
                result.setCallId(TraceUtil.get());
            }
        } catch (Exception e) {
        }
    }
}
