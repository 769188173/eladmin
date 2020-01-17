package me.zhengjie.modules.myTest.switchSource;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 执行数据源脚本
 * @author MaiChiHang
 * @date 2019-11-08
 * @version 0.1
 */
public class MethodImpl {

    @Autowired
    private MethodDao methodDao;

    @DataSourceKey(startDate="2018-05-01",endDate="2019-12-20") // 注：动态参数
    public List list(Map<String,Object> map){
        List<Object> list =  methodDao.fidnAll();
        return list;
    }

     interface MethodDao {
       @Select("select * from t_sjyy_nsrxx where startTime>=#{startDate} and endTime<=#{endDate} and nsrsbh=#{nsrsbh}")
        List<Object> fidnAll();
    }

}







