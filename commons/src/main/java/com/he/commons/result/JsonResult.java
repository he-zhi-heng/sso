package com.he.commons.result;

import com.he.commons.enums.StateCode;
import com.he.commons.exception.BaseException;
import lombok.Data;
import org.slf4j.MDC;

/**
 * @author hemoren
 */
@Data
public class JsonResult<T> {
    private static final String UNIQUE_ID_NAME = "traceId";

    /**
     * 状态码
     * value = "业务状态码"
     * position = 1, example = "200, 400, 401, 403, 404, 409, 500"
     */
    private Integer state;
    /**
     * 消息
     * value = "业务消息"
     * example = "登录失败！密码错误！"
     */
    private String message;
    /**
     * 数据
     * position = 3
     */
    private T data;

    private  String traceId;

    /**
     * 创建响应结果对象，表示"成功"，不封装其它任何数据
     * @return 响应结果对象
     */
    public static JsonResult<String> ok() {
        return ok("OK");
    }

    /**
     *
     * @param data VO
     * @return VO
     * @param <T> 泛型
     */
    public static <T> JsonResult<T> ok(T data) {
        JsonResult<T> jsonResult = new JsonResult<>();
        jsonResult.setState(StateCode.SUCCESS.getValue());
        jsonResult.setData(data);
        jsonResult.setMessage(null);
        jsonResult.setTraceId(MDC.get(UNIQUE_ID_NAME));
        return jsonResult;
    }
    /**
     * 创建响应结果对象，表示"成功"，且封装客户端期望响应的数据
     * @param data 客户端期望响应的数据
     * @return 响应结果对象
     */
    public static <T> JsonResult<T> ok(String message,T data) {
        JsonResult<T> jsonResult = new JsonResult<>();
        jsonResult.setState(StateCode.SUCCESS.getValue());
        jsonResult.setData(data);
        jsonResult.setMessage(message);
        jsonResult.setTraceId(MDC.get(UNIQUE_ID_NAME));
        return jsonResult;
    }
    /**
     * 创建响应结果对象，表示"失败"，且封装"失败"的描述
     *
     * @param e CoolSharkServiceException异常对象
     * @return 响应结果对象
     */
    public static JsonResult<Void> failed(BaseException e) {
        return failed(e.getCode(), e);
    }

    /**
     * 创建响应结果对象，表示"失败"，且封装"失败"的描述
     *
     * @param code "失败"的状态码
     * @param e "失败"时抛出的异常对象
     * @return 响应结果对象
     */
    public static JsonResult<Void> failed(StateCode code, Throwable e) {
        return failed(code, e.getMessage());
    }

    /**
     * 创建响应结果对象，表示"失败"，且封装"失败"的描述
     *
     * @param code "失败"的状态码
     * @param message "失败"的描述文本
     * @return 响应结果对象
     */
    public static JsonResult<Void> failed(StateCode code, String message) {
        JsonResult<Void> jsonResult = new JsonResult<>();
        jsonResult.setState(code.getValue());
        jsonResult.setMessage(message);
        jsonResult.setTraceId(MDC.get(UNIQUE_ID_NAME));
        return jsonResult;
    }
}
