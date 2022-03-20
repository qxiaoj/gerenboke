package com.qj.framework;

import java.io.Serializable;
import java.util.HashMap;

public class R extends HashMap<String, Object> implements Serializable {

    public R() {
        put("code", 200);
        put("message", "操作成功");
    }

    /**
     * 成功，返回200状态码，以及信息
     * @return
     */
    public static R ok() {
        return new R();
    }

    /**
     * 操作失败
     * @return
     */
    public static R err() {
        R r = new R();
        r.put("code", 400);
        r.put("message", "操作失败");
        return r;
    }

    /**
     * 用于put新的值
     * @param key
     * @param value
     * @return
     */
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
