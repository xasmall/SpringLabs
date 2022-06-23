package com.xasmall.lab12.aspect;

import com.xasmall.lab12.annoation.Log;
import com.xasmall.lab12.entity.SysLog;
import com.xasmall.lab12.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogService sysLogService;

    // 用来匹配当前执行方法持有指定注解的方法
    @Pointcut("@annotation(com.xasmall.lab12.annoation.Log)")
    public  void pointcut(){}

    // advice 对于切点要执行的方法
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point){
        Object result = null;
//        方法执行前
        long beginTime = System.currentTimeMillis();

        try {
            // 方法执行
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
//        方法执行后
        long time = System.currentTimeMillis() - beginTime;
        saveLog(point,time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint,long time){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        Log logAnnotation = method.getAnnotation(Log.class);
        if(logAnnotation!=null){
            // 注解上面的描述
            sysLog.setOperation(logAnnotation.value());
        }
        // getTarget获取IOC容器内的目标对象
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className+"."+methodName+"()");

        Object[] args = joinPoint.getArgs();
        // spring提供的获得method的参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);

        if(args!=null && paramNames != null){
            String params = "";
            for(int i=0;i<args.length;i++){
                params += " " + paramNames[i] + ":" + args[i];
            }
            sysLog.setParams(params);
        }
//        模拟一下ip地址
        sysLog.setIp("127.0.0.1");
        sysLog.setUsername("mmmm");
        sysLog.setTime((int)time);
        sysLog.setCreatetime(new Date());
        System.out.println(sysLog+"hhhhhhh");
        sysLogService.saveSysLog(sysLog);
    }


}
