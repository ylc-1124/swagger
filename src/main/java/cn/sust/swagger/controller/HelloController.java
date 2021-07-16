package cn.sust.swagger.controller;

import cn.sust.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "登录接口类")
@RestController
public class HelloController {
    @ApiOperation("hello控制类")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/user")
    public User user(String username,String password) {
        return new User(username,password);
    }
}
