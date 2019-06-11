package com.self.code.serialize.java;

import com.self.code.api.ISerializer;

import java.io.*;

public class JavaSerializer implements ISerializer {


    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream byteArrayOutputStream=
                new ByteArrayOutputStream();
        try {
            ObjectOutputStream outputStream=
                    new ObjectOutputStream(byteArrayOutputStream);

            outputStream.writeObject(obj);

            return  byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(data);
        try {
            ObjectInputStream objectInputStream=
                    new ObjectInputStream(byteArrayInputStream);

            return (T) objectInputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}