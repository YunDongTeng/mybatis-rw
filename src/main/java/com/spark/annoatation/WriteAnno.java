package com.spark.annoatation;

import java.lang.annotation.*;

/**
 * Created by tyd on 2018-1-15.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WriteAnno {
}
