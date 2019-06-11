package com.self.code.api;

/**
 * Created by Administrator on 2019/6/10.
 */
public interface ISerializer {
    <T> byte[] serialize(T obj);
    <T> T deserialize(byte[] data,Class<T> clazz);
}
