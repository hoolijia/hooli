package com.hooli.order;

import com.hooli.order.listener.InitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OrderApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * @author     ：hooli
     * @date       ：Created in 2020/11/24 5:30 下午
     * @description： 将服务注册到zookeeper中
     */
    //@Bean
    //public ServletListenerRegistrationBean servletListenerRegistrationBean() {
    //    ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
    //    servletListenerRegistrationBean.setListener(new InitListener());
    //    return servletListenerRegistrationBean;
    //}
}
