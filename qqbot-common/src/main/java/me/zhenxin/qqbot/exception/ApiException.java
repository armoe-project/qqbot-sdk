package me.zhenxin.qqbot.exception;

import lombok.Getter;

/**
 * API请求异常
 *
 * @author 真心
 * @since 2021/12/14 17:05
 */
@Getter
public class ApiException extends RuntimeException {
    private final Integer code;
    private final String error;

    public ApiException(Integer code, String message, String error) {
        super(message);
        this.code = code;
        this.error = error;
    }
}
