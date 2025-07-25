package eshop.common.api;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BaseResponse<T> {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final boolean success;
    private final String message;
    private final T data;

    private BaseResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(true, "Success", data);
    }

    public static <T> BaseResponse<T> success(String message, T data) {
        return new BaseResponse<>(true, message, data);
    }

    public static <T> BaseResponse<T> fail(String message) {
        return new BaseResponse<>(false, message, null);
    }
}
