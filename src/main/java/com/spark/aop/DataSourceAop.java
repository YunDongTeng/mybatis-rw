package com.spark.aop;

import com.spark.annoatation.ReadAnno;
import com.spark.annoatation.WriteAnno;
import com.spark.config.DataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by tyd on 2018-1-15.
 */
@Aspect
@Component
public class DataSourceAop {


    @Before("execution(* com.spark.service..*.*(..))")
    public void beforeService(JoinPoint jp) {

        MethodSignature methodSignature = (MethodSignature) jp.getSignature();

        Method method = methodSignature.getMethod();

        ReadAnno readAnno = method.getAnnotation(ReadAnno.class);
        if (readAnno != null) {
            DataSourceHolder.setRead();
        } else if (method.getAnnotation(WriteAnno.class) != null) {
            DataSourceHolder.setWrite();
        }
    }
}
