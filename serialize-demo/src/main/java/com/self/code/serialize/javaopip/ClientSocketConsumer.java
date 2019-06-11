package com.self.code.serialize.javaopip;

import com.self.code.api.User;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2019/6/10.
 */
public class ClientSocketConsumer {

    public static void main(String[] args) {
        Socket socket=null;
        ObjectOutputStream objectOutputStream=null;
        try {
            socket=new Socket("127.0.0.1",8080);
            User user=new User();
            user.setAge(18);
            user.setName("wxs");
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
