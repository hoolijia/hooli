package com.hooli.manage.test.redis.resp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author ：hooli
 * @date ：Created in 2020/11/16 10:15 上午
 * @description： jedis简单实现
 */
public class EnjoyRedisClient {
    Socket socket;
    InputStream reader;
    OutputStream writer;

    public EnjoyRedisClient() throws IOException {
        socket = new Socket("127.0.0.1", 6379);
        reader = socket.getInputStream();
        writer = socket.getOutputStream();
    }

    public String set(String k, String v) throws Exception {
        StringBuffer command = new StringBuffer();
        command.append("*3").append("\r\n");
        command.append("$3").append("\r\n");
        command.append("SET").append("\r\n");
        command.append("$").append(k.getBytes().length).append("\r\n");
        command.append(k).append("\r\n");
        command.append("$").append(v.getBytes().length).append("\r\n");
        command.append(v).append("\r\n");

        writer.write(command.toString().getBytes());
        byte[] response = new byte[1024];
        reader.read(response);

        return new String(response);
    }

    public String get(String k) throws Exception {
        StringBuffer command = new StringBuffer();
        command.append("*2").append("\r\n");
        command.append("$3").append("\r\n");
        command.append("GET").append("\r\n");
        command.append("$").append(k.getBytes().length).append("\r\n");
        command.append(k).append("\r\n");

        writer.write(command.toString().getBytes());
        byte[] respone = new byte[1024];
        reader.read(respone);

        return new String(respone);
    }
}
