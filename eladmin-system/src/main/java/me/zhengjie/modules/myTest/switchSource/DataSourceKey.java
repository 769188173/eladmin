package me.zhengjie.modules.myTest.switchSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义数据脚本查询条件注解
 * @author MaiChiHang
 * @date 2019-11-08
 * @version 0.1
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceKey {
    /**起点时间 */
    String startDate();
    /**截止时间 */
    String endDate() ;
}


