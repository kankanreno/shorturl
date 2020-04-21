package edu.sjtu.shorturl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * JSON 模型，用户后台向前台返回的 JSON 对象
 *
 * @author kankan
 */
@Data
@AllArgsConstructor
public class Result {
    private int code;
    private String message;
    private Object data;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
