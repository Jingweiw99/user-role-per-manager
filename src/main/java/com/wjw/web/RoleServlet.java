package com.wjw.web;

import com.wjw.pojo.po.Role;
import com.wjw.pojo.vo.PageResult;
import com.wjw.pojo.vo.QueryPageBean;
import com.wjw.pojo.vo.Result;
import com.wjw.pojo.vo.UpdateUser;
import com.wjw.service.RoleService;
import com.wjw.service.impl.RoleServiceImpl;
import com.wjw.service.impl.UserServiceImpl;
import com.wjw.utils.BaseController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/role/*")
public class RoleServlet extends BaseServlet {
    // 修改用户表需要查询所有的角色，然后通过用户中间表删除对应的关联，然后将新的角色添加上
    /*
    这个方法查询所有的角色
     */
    public void queryRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            RoleService service = new RoleServiceImpl();
            List<Role> roles = service.findAllRoles();
            BaseController.printResult(response, new Result(true, "查询成功！", roles));
        } catch (IOException e) {
            BaseController.printResult(response, new Result(false, "查询失败！"));
            e.printStackTrace();
        }
    }
}
