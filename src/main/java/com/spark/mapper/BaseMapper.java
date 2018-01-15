package com.spark.mapper;

import java.util.List;

/**
 * Created by tyd on 2018-1-15.
 */
public interface BaseMapper<T> {

    List<T> list();

    Integer insert(T t);

}
