package cn.ak47007.service;

/**
 * @Author AK47007
 * @Date 2019/6/29 15:40
 * Describe:
 */
public interface BaseService<T> {

    /**
     * 保存数据
     *
     * @param t
     */
    void save(T t);

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
    T findById(Long id);
}
