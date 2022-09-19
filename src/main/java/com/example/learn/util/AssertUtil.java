package com.example.learn.util;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.learn.exception.BizErrorCode;
import com.example.learn.exception.BizException;
import com.example.learn.exception.ErrorCode;
import com.example.learn.exception.ErrorCode2;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/14 15:42
 */
public class AssertUtil {

    private static final Pattern CHINESE_PATTERN = Pattern.compile("[\u4e00-\u9fa5]");

    /**
     * 私有构造方法
     */
    private AssertUtil() {
    }

    private static final Validator VALIDATOR = new Validator();

    /**
     * 请求参数非空、格式验证，请求对象
     *
     * @param object 请求校验参数
     * @throws BizException 业务异常
     */
    public static void validateObject(Object object) {
        List<ConstraintViolation> list = VALIDATOR.validate(object);
        if (null != list && !list.isEmpty()) {
            throw new BizException(BizErrorCode.PARAMETER_VALID_ERROR, list.get(0).getMessage());
        }
    }

    /**
     * 判断是否为空集合
     *
     * @param collection 集合
     * @param errorCode  异常信息
     * @param <T>        目标对象类型
     */
    public static <T> Collection<T> checkNotEmpty(Collection<T> collection, ErrorCode2 errorCode) {
        return checkNotEmpty(collection, errorCode, null);
    }

    /**
     * 判断是否为空集合
     *
     * @param collection 集合
     * @param errorCode  异常信息
     * @param <T>        目标对象类型
     */
    public static <T> Collection<T> checkNotEmpty(Collection<T> collection, ErrorCode2 errorCode, String msg) {
        if (collection == null || collection.isEmpty()) {
            throw new BizException(errorCode, msg);
        }
        return collection;
    }

    /**
     * 判断为空
     *
     * @param reference 目标对象
     * @param errorCode 异常信息
     * @param <T>       目标对象类型
     */
    public static <T> void checkNull(T reference, ErrorCode2 errorCode, String msg) {
        if (reference != null) {
            throw new BizException(errorCode, msg);
        }
    }

    /**
     * 判断为空
     *
     * @param reference 目标对象
     * @param errorCode 异常信息
     * @param <T>       目标对象类型
     */
    public static <T> void checkNull(T reference, ErrorCode2 errorCode) {
        if (reference != null) {
            throw new BizException(errorCode, null);
        }
    }

    /**
     * 判断是否为空
     *
     * @param reference 目标对象
     * @param errorCode 异常信息
     * @param <T>       目标对象类型
     */
    public static <T> T checkNotNull(T reference, ErrorCode2 errorCode) {
        return checkNotNull(reference, errorCode, null);
    }

    /**
     * 判断是否为空
     *
     * @param reference 目标对象
     * @param errorCode 异常信息
     * @param <T>       目标对象类型
     */
    public static <T> T checkNotNull(T reference, ErrorCode2 errorCode, String msg) {
        if (reference == null) {
            throw new BizException(errorCode, msg);
        }
        return reference;
    }

    /**
     * 判断是否为空
     *
     * @param reference 目标对象
     * @param errorCode 异常信息
     * @param <T>       目标对象类型
     */
    public static <T> T checkNotNull(T reference, ErrorCode2 errorCode, String msg, String param) {
        if (reference == null) {
            throw new BizException(errorCode, msg, param);
        }
        return reference;
    }

    public static String checkNotBlank(String obj, ErrorCode2 bizErrorCode) {
        return checkNotBlank(obj, bizErrorCode, null);
    }

    public static String checkNotBlank(String obj, ErrorCode2 bizErrorCode, String msg) {
        if (StringUtils.isBlank(obj)) {
            throw new BizException(bizErrorCode, msg);
        }
        return obj;
    }

    /**
     * 判断条件是否为真
     *
     * @param condition    判断条件
     * @param bizErrorCode 异常
     */
    public static void isTrue(boolean condition, ErrorCode2 bizErrorCode) {
        isTrue(condition, bizErrorCode, null);
    }

    public static void isTrue(boolean condition, ErrorCode2 bizErrorCode, String msg) {
        if (!condition) {
            throw new BizException(bizErrorCode, msg);
        }
    }

    public static void isNotTrue(boolean condition, ErrorCode2 bizErrorCode) {
        isTrue(!condition, bizErrorCode);
    }

    public static void isNotTrue(boolean condition, ErrorCode2 bizErrorCode, String msg) {
        isTrue(!condition, bizErrorCode, msg);
    }

    public static int checkMin(int expect, int actual, ErrorCode2 bizErrorCode2, String msg) {
        if (actual < expect) {
            throw new BizException(bizErrorCode2, msg);
        }
        return actual;
    }

    public static int checkMin(int expect, int actual, ErrorCode2 bizErrorCode2) {
        return checkMin(expect, actual, bizErrorCode2, null);
    }

    public static void checkEquals(String left, String rigtht, ErrorCode2 errCode, String msg) {
        if (!StringUtils.equals(left, rigtht)) {
            throw new BizException(errCode, msg);
        }
    }

    public static void checkEquals(String left, String rigtht, ErrorCode2 errCode) {
        checkEquals(left, rigtht, errCode, null);
    }


    public static boolean allNotNull(Object... objs) {
        if (null == objs) {
            return false;
        }
        for (Object obj : objs) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }


    /**
     * 检查字符串是否包含中文
     */
    public static boolean isChinese(String str) {

        Matcher matcher = CHINESE_PATTERN.matcher(str);
        return matcher.find();
    }

    public static ValueFilter filter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if (v == null) {
                return "";
            }
            return v;
        }
    };
}
