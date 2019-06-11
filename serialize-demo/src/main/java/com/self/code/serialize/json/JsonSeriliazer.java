package com.self.code.serialize.json;

import com.alibaba.fastjson.JSON;
import com.self.code.api.ISerializer;

/**
 * Created by Administrator on 2019/6/10.
 */
public class JsonSeriliazer implements ISerializer {
    public <T> byte[] serialize(T obj) {
        return JSON.toJSONString(obj).getBytes();
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return JSON.parseObject(new String(data),clazz);
    }
}
