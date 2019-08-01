package cn.ak47007.controller;

import cn.ak47007.pojo.ResultVO;
import cn.ak47007.pojo.User;
import cn.ak47007.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author AK47007
 * @Date 2019/6/29 15:42
 * Describe:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findByRole")
    public List<User> findByRole(@RequestParam("role") Integer role) {
        return userService.findByRole(role);
    }

    @RequestMapping("/save")
    public ResultVO save(@RequestBody User user) {
        try {
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVO(500, "failed");
        }
        return new ResultVO(200, "success");
    }

    @RequestMapping("/deleteById")
    public ResultVO deleteById(@RequestParam("id") Long id) {
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultVO(500, "failed");
        }
        return new ResultVO(200, "success");
    }

    @RequestMapping("/findById")
    public User findById(@RequestParam("id") Long id) {
        try {
            return userService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
