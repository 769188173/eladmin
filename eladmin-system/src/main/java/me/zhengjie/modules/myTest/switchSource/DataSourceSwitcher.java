package me.zhengjie.modules.myTest.switchSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源切换
 * @author MaiChiHang
 * @date 2019-11-08
 * @version 0.1
 */
public class DataSourceSwitcher extends AbstractRoutingDataSource {
    private static final ThreadLocal<Enum> dataSourceKey = new ThreadLocal<Enum>();
    public static void clearDataSourceType() {
        dataSourceKey.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        Enum s = dataSourceKey.get();
        return s;
    }

    public static void setDataSourceKey(Enum<AopSourceSwitcher.EnmuDataSource> dataSource) {
        dataSourceKey.set(dataSource);
    }
}