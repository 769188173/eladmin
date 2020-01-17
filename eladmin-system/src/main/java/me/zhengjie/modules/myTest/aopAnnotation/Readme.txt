添加切面依赖:
<dependency>
      <groupId>org.aspectj</groupId>
      <artifactId>aspectjrt</artifactId>
      <version>1.8.5</version>
</dependency>

________________________________________________

1 注解代码：
package  com.test.aop.service
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Document
public @interface LogPrint{
    //可附加属性
    public String desc();//注意属性后面有括号
}

_________________________________________________

2 切面代码：
package  com.test.aop.util
@Aspect
@Component
public class LogPrintAspect{
    //自定义切点位置
    //把切面连接点放在我们注解上
    @Pointcut("@annotation(com.test.aop.service.LogPrint)")
    private void controllerAspect(){}
    //自定义前置切面
    //访问controller方法前先执行的方法
    @Before("controllerAspect()")
    public void printLog(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ms");
        System.out.println(sdf.format(new Date())+" || ");
    }
}

_________________________________________________

需获取注解属性的代码：
package  com.test.aop.util
@Aspect
@Component
public class LogPrintAspect{
    //自定义切点位置
    //把切面连接点放在我们注解上
    @Pointcut("@annotation(com.test.aop.service.LogPrint)")
    private void controllerAspect(){}
    //自定义前置切面
    //访问controller方法前先执行的方法
    @Before(value = "controllerAspect()&&@annotation(logPrint)", argNames = "logPrint")
    public void printLog(LogPrint logPrint){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ms");
        System.out.println(sdf.format(new Date())+" || "+ logPrint.desc());
    }
}

_________________________________________________

3 带属性的：
@LogPrint(desc = "属性描述")
@RequestMapping(value = "/toIndex" method = RequestMethod.GET)
public ModelAndView toIndex(){
    ModelAndView mav = new ModelAndView();
    mav.setViewName("index");
    return(mav);
}
