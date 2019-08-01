package cn.ak47007.service;

import cn.ak47007.pojo.User;

import java.util.List;

/**
 * @Author AK47007
 * @Date 2019/6/29 15:40
 * Describe:
 */
public interface UserService extends BaseService<User> {

    /**
     * 新增数据
     *
     * @param user
     */
    void insertUser(User user);

    /**
     * 修改
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据用户角色查询
     *
     * @param role
     * @return
     */
    List<User> findByRole(Integer role);
}
