package com.lrm.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    //输出一个日志记录
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //通过这个注解说明它是一个切面,execution()里边的内容说明来拦截哪些类，希望拦截下面的类
    @Pointcut("execution(* com.lrm.blog.web.*.*(..))")
    //定义切面
    public void log(){}


    /*
    使这个方法在这个切面之前执行应该怎么做，要声明before
     */
    @Before("log()")//括号里边传递这个切面
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod=joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
        //请求的参数
        Object[] args=joinPoint.getArgs();
        RequestLog requestLog =new RequestLog(url,ip,classMethod,args);

        logger.info("Request : {}",requestLog);

    }
    @After("log()")
    public void doAfter(){
        logger.info("--------doafter-------");
    }
    /*
    方法返回
     */
    @AfterReturning(returning = "result",pointcut ="log()")//返回的值，通过result传的参数来捕获这些拦截的方法所返回的内容。
    public void doAfterReturn(Object result){
        logger.info("Result : {}",result);//获取返回内容
    }
    public class RequestLog {
        private String url;
        private  String ip;
        private  String ClassMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            ClassMethod = classMethod;
            this.args = args;

        }
        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", ClassMethod='" + ClassMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
