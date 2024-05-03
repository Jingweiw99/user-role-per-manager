package com.wjw.utils;

import java.util.HashMap;
import java.util.ResourceBundle;

// 通过反射和配置文件的方式创建对象
public class BeansFactory {
    /*
        key            value
        userService    UserServiceImpl0x001
        roleService    RoleServiceImpl0x002
    */
    private static HashMap<String, Object> map = new HashMap<>();
    // 例子 UserService userService = BeansFactory.getInstance("userService") 需要对应beans.properties中的key
    public static synchronized <T> T getInstance(String key) throws Exception {
        Object obj = map.get(key);
        if (obj == null) {
            ResourceBundle bundle = ResourceBundle.getBundle("beans");//不能书写后缀名
            String classNameStr = bundle.getString(key);
            Class<?> clazz = Class.forName(classNameStr);
            obj = clazz.newInstance();
            map.put(key, obj);
        }
        return (T) obj;
    }

}
