package com.wjw.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*   FastJson封装
* */
public class BaseController {
    //将对象转换为json数据并响应给前端
    public static void printResult(HttpServletResponse response, Object obj) throws IOException {
        //response.setContentType("application/json;charset=utf8");// 过滤器已经做了
        //将参数接收的对象obj响应给浏览器
        JSON.writeJSONString(response.getWriter(),obj);
    }
    //将前端提交的json数据转换为java对象
    public static  <T> T parseJSON2Object(HttpServletRequest request, Class<T> tClass) throws IOException{
        // 把json格式的表单数据直接转成T类型的对象
        return JSON.parseObject(request.getInputStream(),tClass);
    }
}
