package com.charlee;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZooKeeperProSync  implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk = null;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws Exception {
        //zookeeper配置数据存放路径
        String path = "/username";
        //连接zookeeper并且注册一个默认的监听器
        zk = new ZooKeeper("62.234.138.47:2181", 5000, //
                new ZooKeeperProSync());
        //等待zk连接成功的通知
        connectedSemaphore.await();
        
     // 创建一个目录节点
        zk.create("/testRootPath", "testRootData".getBytes(), Ids.OPEN_ACL_UNSAFE,
          CreateMode.PERSISTENT); 
        // 创建一个子目录节点
        zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
          Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT); 
        System.out.println(new String(zk.getData("/testRootPath",false,null))); 
        // 取出子目录节点列表
        System.out.println(zk.getChildren("/testRootPath",true)); 
        // 修改子目录节点数据
        zk.setData("/testRootPath/testChildPathOne","modifyChildDataOne".getBytes(),-1); 
        System.out.println("目录节点状态：["+zk.exists("/testRootPath",true)+"]"); 
        // 创建另外一个子目录节点
        zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(), 
          Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo",true,null)));
        // 删除子目录节点
//        zk.delete("/testRootPath/testChildPathTwo",-1); 
//        zk.delete("/testRootPath/testChildPathOne",-1); 
        // 删除父目录节点
//        zk.delete("/testRootPath",-1); 
        // 关闭连接
//        zk.close();
        
        //获取path目录节点的配置数据，并注册默认的监听器
        System.out.println(new String(zk.getData(path, true, stat)));

        Thread.sleep(Integer.MAX_VALUE);
    }

    public void process(WatchedEvent event) {
    	
    	System.out.println(event.getPath() +":" + event.getType());
        if (KeeperState.SyncConnected == event.getState()) {  //zk连接成功通知事件
            if (EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();
            } else if (event.getType() == EventType.NodeDataChanged) {  //zk目录节点数据变化通知事件
                try {
                    System.out.println("配置已修改，新值为：" + new String(zk.getData(event.getPath(), true, stat)));
                } catch (Exception e) {
                }
            }
        }
    }
}
