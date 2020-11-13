package com.hooli.manage;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hooli
 * @date ：Created in 2020/10/29 3:27 下午
 * @description：
 */
@SpringBootTest
public class ZkTest {

    private String path = "/testNode";
    private String connect = "127.0.0.1:2181";
    private int time = 5000;

    private ZooKeeper zooKeeper;

    /**
     * @author ：hooli
     * @date ：Created in 2020/10/29 3:44 下午
     * @description： zookeeper 简单创建节点
     */
    @Test
    public void createNode() throws Exception {

        ZooKeeper zooKeeper = new ZooKeeper(connect, time, null);
        Stat exists = zooKeeper.exists(path, false);
        if (exists == null) {
            zooKeeper.create(path, "hooli".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        zooKeeper.close();
    }

    /**
     * @author ：hooli
     * @date ：Created in 2020/10/29 3:46 下午
     * @description： zookeeper 添加监听
     */
    @Test
    public void createWatch() throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper(connect, time, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getType() == Event.EventType.NodeDeleted && path.equals(watchedEvent.getPath())) {
                    System.out.println("testNode节点已经不在了");
                }
            }
        });

        Stat exists = zooKeeper.exists(path, true);
        if (exists != null) {
            zooKeeper.delete(path, -1);
        }

        Thread.sleep(3);
        zooKeeper.close();
    }

    @Test
    public void initZK() {
        try {
            zooKeeper = new ZooKeeper(connect, time, (watchedEvent) -> {
                // 当有节点变更的时候通知orderService
                if (watchedEvent.getType() == Watcher.Event.EventType.NodeChildrenChanged
                        && watchedEvent.getPath().equals("/services/orders")) {
                    this.updateServerList();
                }
                this.updateServerList();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author ：hooli
     * @date ：Created in 2020/11/1 1:31 下午
     * @description： 更新zk中最新的服务列表
     */
    private void updateServerList() {
        List<String> newServerList = new ArrayList<>();
        try {
            List<String> children = zooKeeper.getChildren("/services/orders", true);
            for (String subNode : children) {
                byte[] data = zooKeeper.getData("/services/orders" + "/" + subNode, false, null);
                String host = new String(data, "utf-8");
                System.out.println("host：" + host);
                newServerList.add(host);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
