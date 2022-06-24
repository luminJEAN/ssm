package com.lm.ssm.filter;

import com.lm.ssm.entity.Emp;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandlerIntercepter  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("loginUser");
        System.out.println("login拦截");
        System.out.println(obj);
        if (obj != null){
            //已经登录，放行
            return true;

        }else {
            //未登录， 重定向到登录页
            System.out.println("没有登陆，请先登陆");
            response.sendRedirect(request.getContextPath()+"/");
            return false;
        }
//        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("==========FirstInterceptor postHandle==========");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("==========FirstInterceptor afterCompletion==========");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
