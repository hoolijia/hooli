package com.hooli.order.listener;

import com.hooli.order.zk.ServiceRegister;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.InetAddress;
import java.util.Properties;

/**
 * @author ：hooli
 * @date ：Created in 2020/10/29 5:22 下午
 * @description：
 */
public class InitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Properties properties = new Properties();
            properties.load(InitListener.class.getClassLoader().getResourceAsStream("application.properties"));

            // get ip
            String ip = InetAddress.getLocalHost().getHostAddress();

            // get port
            int port = Integer.valueOf(properties.getProperty("server.port"));

            ServiceRegister.register(ip, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
