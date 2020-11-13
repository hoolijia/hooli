package com.hooli.user.listener;

import com.hooli.core.constant.ZKConstant;
import com.hooli.user.utils.LoadBalance;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hooli
 * @date ：Created in 2020/11/9 1:49 下午
 * @description：监听
 */
public class InitListener implements ServletContextListener {

    private ZooKeeper zooKeeper;

    private void init() {
        try {
            zooKeeper = new ZooKeeper(ZKConstant.CONNECT, ZKConstant.TIME, (watchedEvent) -> {
                if (watchedEvent.getType() == Watcher.Event.EventType.NodeChildrenChanged
                        && watchedEvent.getPath().equals(ZKConstant.BASE_SERVICES + ZKConstant.SERVICE_NAME)) {
                    updateServerList();
                }
            });

            // 第一次连接时获取zk中的列表
            updateServerList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateServerList() {
        List<String> serverList = new ArrayList<>();
        try {
            List<String> children = zooKeeper.getChildren(ZKConstant.BASE_SERVICES + ZKConstant.SERVICE_NAME, true);
            for (String node : children) {
                byte[] data = zooKeeper.getData(ZKConstant.BASE_SERVICES + ZKConstant.SERVICE_NAME + "/" + node, false, null);
                String host = new String(data, "utf-8");
                System.out.println("host:" + host);
                serverList.add(host);
            }
            LoadBalance.SERVICE_LIST = serverList;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
