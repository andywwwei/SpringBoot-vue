package cn.ak47007.service;

import cn.ak47007.mapper.UserMapper;
import cn.ak47007.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author AK47007
 * @Date 2019/6/29 15:40
 * Describe:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public List<User> findByRole(Integer role) {
        return userMapper.findByRole(role);
    }

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            insertUser(user);
        } else {
            updateUser(user);
        }
    }

    @Override
    public void deleteById(Long id) {
        userMapper.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }
}
