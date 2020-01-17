package me.zhengjie.modules.myTest.aopAnnotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LogPrintAspect {

    @Pointcut("@annotation(me.zhengjie.modules.myTest.aopAnnotation.LogPrint)")
    private void controllerAspect(){}

    @Before(value = "controllerAspect()&&@annotation(logPrint)", argNames = "logPrint")
    public void printLog(LogPrint logPrint){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ms");
        System.out.println(sdf.format(new Date())+" || "+ logPrint.desc());
    }
}
