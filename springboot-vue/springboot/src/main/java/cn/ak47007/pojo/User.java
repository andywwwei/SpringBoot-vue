package cn.ak47007.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author AK47007
 * @Date 2019/6/29 15:33
 * Describe:用户
 */
@Data
public class User implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date userBirthDay;

    /**
     * 出生地
     */
    private String userAddress;

    /**
     * 手机号码
     */
    private String userPhone;

    /**
     * 用户角色,1.管理员,2.普通用户
     */
    private Integer userRole;
}
