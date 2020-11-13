package com.hooli.manage.test.redis.jedis.socket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：hooli
 * @date ：Created in 2020/11/13 10:47 上午
 * @description： socket服务端
 */
public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        // 代码阻塞，等待客户端连接
        Socket socket = serverSocket.accept();

        // 将消息读到btye数组里
        InputStream reader = socket.getInputStream();
        byte[] request = new byte[1024];
        reader.read(request);

        // 转化成String 输出
        String req = new String(request);
        System.out.println(req);

        serverSocket.close();
    }
}
