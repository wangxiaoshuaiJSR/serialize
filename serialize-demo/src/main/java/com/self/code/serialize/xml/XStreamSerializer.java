package com.self.code.serialize.xml;

import com.self.code.api.ISerializer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamSerializer implements ISerializer {

    XStream xStream=new XStream(new DomDriver());


    public <T> byte[] serialize(T obj) {

        return xStream.toXML(obj).getBytes();
    }

    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return (T)xStream.fromXML(new String(data));
    }
}