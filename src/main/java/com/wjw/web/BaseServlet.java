package com.wjw.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

//@WebServlet("/BaseServlet")

/**
 * 这个是基础的Servlet 使得其他的功能不必每一个请求都写一个Servlet，让功能内聚。
 */
public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();// /user/findAll  /user/update
        int lastIndex = uri.lastIndexOf("/");

        String methodName = uri.substring(lastIndex + 1);
        // ！！！ 这里可以通过if判断每个方法，然后执行对应的方法
        // 但是通过反射获取到对应继承的子对象实例，然后方法对象调用，好一点
        try {
            Class<?> clazz = this.getClass();
            Method m = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            m.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
