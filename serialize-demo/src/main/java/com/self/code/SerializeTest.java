package com.self.code;

import com.self.code.api.ISerializer;
import com.self.code.api.User;
import com.self.code.serialize.hessian.HessianSerializer;
import com.self.code.serialize.java.JavaSerializer;
import com.self.code.serialize.json.JsonSeriliazer;
import com.self.code.serialize.xml.XStreamSerializer;

/**
 * Created by Administrator on 2019/6/11.
 */
public class SerializeTest {
    public static void main(String[] args) {
      //  ISerializer iSerializer=new JsonSeriliazer();

    //    ISerializer iSerializer=new HessianSerializer();
        ISerializer iSerializer=new XStreamSerializer();
        User user = new User();
        user.setName("wcxs");
        user.setAge(18);
        byte[] bytes = iSerializer.serialize(user);
        System.out.println(new String(bytes));

        User user1=iSerializer.deserialize(bytes,User.class);
        System.out.println(user1);
    }
}
