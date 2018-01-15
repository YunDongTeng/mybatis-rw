package com.spark.annoatation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * Created by tyd on 2018-1-15.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ReadAnno {
}
