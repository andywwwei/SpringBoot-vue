package cn.ak47007.mapper;

import cn.ak47007.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author AK47007
 * @Date 2019/6/29 15:37
 * Describe:
 */
@Mapper
@Component
public interface UserMapper {

    /**
     * 根据用户角色查询
     *
     * @param role
     * @return
     */
    List<User> findByRole(Integer role);

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
     * 根据ID删除
     *
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据 ID查询
     *
     * @param id
     * @return
     */
    User findById(Long id);
}
