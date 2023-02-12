package com.fandf.im.common;

import com.fandf.im.common.exception.ApplicationExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author dongfengfan
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO<T> {

    private int code;

    private String msg;

    private T data;

    public static <T> ResponseVO<T> successResponse(T data) {
        return new ResponseVO<T>(200, "success", data);
    }

    public static <T> ResponseVO<T> successResponse() {
        return new ResponseVO<T>(200, "success");
    }

    public static <T> ResponseVO<T> errorResponse() {
        return new ResponseVO<T>(500, "系统内部异常");
    }

    public static <T> ResponseVO<T> errorResponse(int code, String msg) {
        return new ResponseVO<T>(code, msg);
    }

    public static <T> ResponseVO<T> errorResponse(ApplicationExceptionEnum enums) {
        return new ResponseVO<T>(enums.getCode(), enums.getError());
    }

    public boolean isOk() {
        return this.code == 200;
    }


    public ResponseVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
//		this.data = null;
    }

    public ResponseVO<T> success() {
        this.code = 200;
        this.msg = "success";
        return this;
    }

    public ResponseVO<T> success(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
        return this;
    }

}
