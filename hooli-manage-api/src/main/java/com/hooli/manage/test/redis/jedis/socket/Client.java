package com.hooli.manage.test.redis.jedis.socket;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @author ：hooli
 * @date ：Created in 2020/11/13 10:52 上午
 * @description： socket客户端
 */
public class Client {

    public static void main(String[] args) throws Exception {
        // 连接server
        Socket socket = new Socket("127.0.0.1", 8888);
        // 获得输出流
        OutputStream writer = socket.getOutputStream();

        // 发送消息给服务器
        writer.write("hello world".getBytes());
        socket.close();
    }
}
