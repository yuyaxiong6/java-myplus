package com.atguigu.dpdemo1010;

import com.atguigu.dpdemo1010.entity.User;
import com.atguigu.dpdemo1010.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public  class Dpdemo1010ApplicationTests {

     @Autowired
     private UserMapper userMapper;
    @Test
    public  void selectall() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }

}
