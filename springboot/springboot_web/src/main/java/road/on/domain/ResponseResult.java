package road.on.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 统一 接口响应格式
 * @param <T>
 */

// 这个注解是JackSon中最常用的注解之一，可以为实体类在接口序列化返回值时 增加规则，
// NON_NULL 表示值为null就不序列化，即值为null的字段不返回
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 提示信息，如果有错误时，前端可以获取该字段进行提示
     */
    private String msg;
    /**
     * 查询到的结果数据
     */
    private T data;


    public ResponseResult(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }


    public ResponseResult(Integer code, T data){
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
