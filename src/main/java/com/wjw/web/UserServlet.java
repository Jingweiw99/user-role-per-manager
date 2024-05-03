package com.wjw.web;

import com.wjw.pojo.po.User;
import com.wjw.pojo.vo.QueryPageBean;
import com.wjw.pojo.vo.Result;
import com.wjw.service.UserService;
import com.wjw.service.impl.UserServiceImpl;
import com.wjw.utils.BaseController;
import com.wjw.utils.BeansFactory;
import com.wjw.pojo.vo.PageResult;

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
            BaseController.printResult(response, result);
        } catch (Exception e) {
            try {
                e.printStackTrace();
                Result result = new Result(false, "查询所有用户失败");
                BaseController.printResult(response, result);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    protected void add(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("add");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("delete");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("update");
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            QueryPageBean queryPageBean = BaseController.parseJSON2Object(request, QueryPageBean.class);
            System.out.println(queryPageBean);
            UserServiceImpl service = new UserServiceImpl();
            PageResult page = service.selectByPage(queryPageBean);
            BaseController.printResult(response, new Result(true, "查询成功！", page));
        } catch (IOException e) {
            e.printStackTrace();
            BaseController.printResult(response, new Result(false, "查询失败！"));

        }
    }
}
