package me.zhengjie.modules.myTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Description: TODO
 * @Author Administrator
 * @Date 2019/11/11/011
 * @Version V1.0
 **/
public class test {
    public static void main(String[] args) throws ParseException {
        String s = "2019-11-10T16:00:00:00.000Z";
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simple.parse(s));
    }
}
