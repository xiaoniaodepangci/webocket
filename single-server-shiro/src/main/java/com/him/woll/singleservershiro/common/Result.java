package com.him.woll.singleservershiro.common;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 返回数据
 */
public class Result extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public Result() {
        put("code", 0);
        put("msg", "success");
    }

    public static Result error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static Result ok(String msg) {
        Result result = new Result();
        result.put("msg", msg);
        return result;
    }

    public static Result ok(Map<String, Object> map) {
        Result result = new Result();
        result.putAll(map);
        return result;
    }

    public static Result ok() {
        return new Result();
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 列表数据
     *
     * @param list      数据
     * @param currPage  当前页
     * @param pageSize  分页
     * @param totalPage 总页数
     * @param total     总行数
     * @return 列表数据
     */
    public static Result list(Object list, Long currPage, Long pageSize, Long totalPage, Long total) {
        Result result = new Result();
        result.put("list", list);
        result.put("currPage", currPage);
        result.put("pageSize", pageSize);
        result.put("totalPage", totalPage);
        result.put("total", total);
        return result;
    }
}
