package cn.ak47007.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author AK47007
 * @Date 2019/6/29 16:58
 * Describe:
 */
@Data
public class ResultVO implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;


    public ResultVO() {
    }

    public ResultVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
