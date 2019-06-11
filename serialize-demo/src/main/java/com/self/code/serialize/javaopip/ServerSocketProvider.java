package com.self.code.serialize.javaopip;

import com.self.code.api.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2019/6/10.
 */
public class ServerSocketProvider {
    public static void main(String[] args) {
        ServerSocket serverSocket=null;
        Socket socket =null;
        ObjectInputStream objectInputStream =null;
        try {
            serverSocket=new ServerSocket(8080);
            socket = serverSocket.accept();
            objectInputStream=new ObjectInputStream(socket.getInputStream());
            User user= (User) objectInputStream.readObject();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(objectInputStream!=null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
