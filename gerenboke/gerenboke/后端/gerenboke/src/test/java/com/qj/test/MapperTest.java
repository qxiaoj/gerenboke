package com.qj.test;

import com.qj.entity.User;
import com.qj.service.UserService;
import com.qj.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MapperTest {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.getByUserName("admin");
        System.out.println(admin);
    }

    @Autowired
    private UserService userService;

    @Test
    public void demo1() {
        User admin = userService.getByUserName("admin");
        System.out.println(admin);
    }
}
