package me.zhengjie.modules.myTest.switchSource;

import java.util.ArrayList;
import java.util.Date;

/**
 * 冷热数据查询
 * @author MaiChiHang
 * @date 2019-11-08
 * @version 0.1
 */
public class AopSourceSwitcher {
    private static Date coldEndTime = new Date();//冷库截止时间
    private static Date hotStartTime = new Date(); //热库起点时间

    /**
     * 1.如果起始时间<热库起点时间 且 截止时间 > 冷库截止时间就提示错误,否则下一步
     * 2.查询起点时间大于热数据起点时间，则查询热数据库，否则查询冷数据库
     * @param startTime 起始时间
     * @param endTime 截止时间
     * @return boolean
     */
    public static Object  isDataSource(Date startTime,Date endTime){
        if(startTime.compareTo(hotStartTime)==-1&&endTime.compareTo(coldEndTime)==1){
                return "提示:跨多年数据查询只能更新到上个月";
        }else{
            if(startTime.compareTo(hotStartTime)==1)
                /** 切换到热库 */
                DataSourceSwitcher.setDataSourceKey(EnmuDataSource.hotSource);
            else
                /** 切换到冷库 */
                DataSourceSwitcher.setDataSourceKey(EnmuDataSource.coldSource);
            String sql = "select * from t_sjyy_nsrxx where startTime>=#{startDate} and endTime<=#{endDate} and nsrsbh=#{nsrsbh}" ;
            return  new ArrayList();
        }
    }

    /**
     * 设置冷库截止时间和热库开始时间，从数据库获取
     * @param coldEndTime 冷库截止时间
     * @param hotStartTime 热库开始时间
     */
    public static void setTime(Date coldEndTime,Date hotStartTime) {
        AopSourceSwitcher.hotStartTime = hotStartTime;
        AopSourceSwitcher.coldEndTime = coldEndTime;
    }

    /**
     * 数据源类型枚举
     */
    enum EnmuDataSource {
        /**冷库数据源 */
        coldSource,
        /**热库数据源 */
        hotSource
    }
}




