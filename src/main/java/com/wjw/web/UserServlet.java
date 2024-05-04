package com.wjw.web;

import com.wjw.pojo.po.User;
import com.wjw.pojo.vo.*;
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

    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            AddUser addUser = BaseController.parseJSON2Object(request, AddUser.class);
            UserService service = BeansFactory.getInstance("userService");
            service.addUser(addUser);
            BaseController.printResult(response, new Result(true, "添加用户成功！"));
        } catch (IOException e) {
            BaseController.printResult(response, new Result(false, "添加用户失败！"));
            e.printStackTrace();
        }

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("delete");
    }
    // 用户更新
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            UpdateUser updateUser = BaseController.parseJSON2Object(request, UpdateUser.class);
            UserService userService = BeansFactory.getInstance("userService");
            userService.update(updateUser);
            Result result = new Result(true, "更新用户成功");
            BaseController.printResult(response,result);
        } catch (Exception e) {
            Result result = new Result(false, "更新用户失败");
            BaseController.printResult(response,result);
            e.printStackTrace();
        }
    }
    // 分页查询
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            QueryPageBean queryPageBean = BaseController.parseJSON2Object(request, QueryPageBean.class);
            System.out.println(queryPageBean);
//            UserServiceImpl service = new UserServiceImpl();
            UserService service = BeansFactory.getInstance("userService");
            PageResult page = service.selectByPage(queryPageBean);
            BaseController.printResult(response, new Result(true, "查询成功！", page));
        } catch (IOException e) {
            e.printStackTrace();
            BaseController.printResult(response, new Result(false, "查询失败！"));

        }
    }
}
