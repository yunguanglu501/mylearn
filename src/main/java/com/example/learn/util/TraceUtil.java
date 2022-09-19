package com.example.learn.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * TraceUtil 提供日志追踪功能
 *
 */
public class TraceUtil {

    public static void put() {
        MDC.put("TraceID", UUID.randomUUID().toString().replace("-",""));
    }

    public static void put(String traceId) {
        if (StringUtils.isBlank(traceId)) {
            put();
            return;
        }
        MDC.put("TraceID", traceId);
    }

    public static String get() {
        return StringUtils.isEmpty(MDC.get("TraceID")) ? UUID.randomUUID().toString().replace("-","") : MDC.get("TraceID");
    }

    public static void clear() {
        MDC.clear();
    }
}
