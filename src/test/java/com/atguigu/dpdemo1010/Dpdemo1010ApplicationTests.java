package com.atguigu.dpdemo1010;

import com.atguigu.dpdemo1010.entity.User;
import com.atguigu.dpdemo1010.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
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
   ///////插入测试
    @Test
    public  void testinsert()
    {
        User user =new User();
        user.setAge(18);
        user.setName("1强");
        user.setEmail("7642@qq.com");
        int result = userMapper.insert(user);
        System.out.println("-——————"+result);

    }
     //////更新测试
    @Test
    public  void  update(){
        User user =new User();
        user.setId(2L);
        user.setAge(120);
        int result = userMapper.updateById(user);
        System.out.println("影响行数："+result);

    }

    //乐观锁测试
    @Test
    public  void  testOptimisticLocker(){
        //根据id查询数据

        User user=userMapper.selectById(1405132834989002754L);
        //进行修改
        user.setAge(200);
        userMapper.updateById(user);

    }
    //多个id批量查询
    @Test
    public  void  testselectDemo1(){
        List<User> users=userMapper.selectBatchIds(Arrays.asList(1,2,3));
        System.out.println(users);


    }
    //分页查询
    @Test
    public  void testpageHelper(){
        //1.创建page对象
        Page<User> page=new Page<>(1,3);
        //调用mapper的分页方法
        //把分页所有的数据封装到page对象里面
        userMapper.selectPage(page,null);
        System.out.println("当前页"+page.getCurrent());//当前页
        System.out.println(page.getRecords());//煤业数据list集合
        System.out.println(page.getTotal());//总记录数
        System.out.println(page.getPages());//总页数


        System.out.println(page.hasNext());//下一页
        System.out.println(page.hasPrevious());//上一页

    }
        /**
       2 * 测试 逻辑删除
        3 */
         @Test
         public void testLogicDelete() {
         int result = userMapper.deleteById(1405146835495964674L);
         System.out.println(result);
         }

         //mp实现复杂查新操作
    @Test
    public void testSelectQuery() {
      //创建QueryWrapper对象
        QueryWrapper<User> wrapper=new QueryWrapper<>();

        ///通过QueryWrapper设置条件
        //ge gt le  lt
        //查询age》=30的记录
        wrapper.ge("age",10);
        List<User>users=userMapper.selectList(wrapper);
        System.out.println(wrapper);

        //eq ne   ==和！=

        //like

        //orderByDesc

        //last





    }

    //制定查询的列
    @Test
    public void testSelectListLast() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("limit 1");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }


}
