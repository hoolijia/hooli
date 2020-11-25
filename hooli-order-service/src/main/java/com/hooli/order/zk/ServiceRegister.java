package com.hooli.order.zk;

import com.hooli.core.constant.ZKConstant;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @author ：hooli
 * @date ：Created in 2020/10/29 5:33 下午
 * @description： zk服务注册
 */
public class ServiceRegister {

    public static void register(String address, int port) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper(ZKConstant.CONNECT, ZKConstant.TIME, (watchedEvent) -> {
            });
            Stat exists = zooKeeper.exists(ZKConstant.BASE_SERVICES , false);
            if (exists == null) {
                zooKeeper.create(ZKConstant.BASE_SERVICES, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }

            Stat exists2 = zooKeeper.exists(ZKConstant.BASE_SERVICES + ZKConstant.SERVICE_NAME, false);
            if (exists2 == null) {
                zooKeeper.create(ZKConstant.BASE_SERVICES + ZKConstant.SERVICE_NAME, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            String server_path = address + ":" + port;
            zooKeeper.create(ZKConstant.BASE_SERVICES + ZKConstant.SERVICE_NAME + "/child", server_path.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println("订单服务注册成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
