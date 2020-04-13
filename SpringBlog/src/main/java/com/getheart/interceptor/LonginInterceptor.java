package com.getheart.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Json
 * @date 2020-31-18:06
 */
public class LonginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

            if (request.getSession().getAttribute("user") == null){
                request.setAttribute("msg","没有限权请先登录！");
                request.getRequestDispatcher("/admin").forward(request,response);
                return false;
            }

            return true;
        }

}
