package com.wjw.web;

import com.wjw.pojo.po.User;
import com.wjw.pojo.vo.Result;
import com.wjw.service.UserService;
import com.wjw.utils.BaseController;
import com.wjw.utils.BeansFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    public void findAllUser(HttpServletRequest request, HttpServletResponse response) {
        try {
//            List<User> users = BaseController.parseJSON2Object(request, List.class);
            UserService userService = BeansFactory.getInstance("userService");
            List<User> users = userService.findAllUser();
            for (User user : users) {
                System.out.println(user);
            }
            Result result = new Result(true, "查询用户成功", users);
            BaseController.printResult(response,result);
        } catch (Exception e) {
            try {
                e.printStackTrace();
                Result result = new Result(false, "查询所有用户失败");
                BaseController.printResult(response,result);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }
}
