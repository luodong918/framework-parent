package com.framework.parent.aspect;


import com.framework.parent.common.LogTypeEnum;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * @author gongjunyi
 * @date 2019年02月27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**
     * 日志类型
     */
    LogTypeEnum type();

    /**
     * 返回结果
     */
    String logResult() default "";

    /**
     * 异常
     */
    String logException() default "";


}

