package com.lrm.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler{
    private Logger logger= LoggerFactory.getLogger(this.getClass());//打印异常this=ControllerExceptionHandler  记录日志，拿到这个一个对象

    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e)throws Exception{//HttpServletRequest request获取请求路径，从而找出出错的方法
        logger.error("request URL :{},Exception : {}",request.getRequestURL(), e);//希望记录哪些异常信息request.getRequestURL()传递一下，即把拿到的错误信息传到{}里。
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!=null) {
            throw e;
        }
        //记录之后希望返回错误页面
        ModelAndView mv=new ModelAndView();
        System.out.println("----------");
        mv.addObject("url",request.getRequestURL());//前端页面可以获取url，放到这个对象里边来，
        mv.addObject("exception", e);
        mv.setViewName("error/error");//返回到哪个页面。
        return mv;
    }

}
