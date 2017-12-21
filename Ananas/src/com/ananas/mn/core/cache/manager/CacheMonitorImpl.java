package com.ananas.mn.core.cache.manager;

import com.ananas.mn.core.log.Log;

import java.util.List;
import java.util.concurrent.Executor;

public class CacheMonitorImpl implements CacheMonitor {

    protected static final Log log = Log.getLogger(CacheMonitorImpl.class);

    protected int period = 60000;
    protected volatile boolean stop = false;

    private List<CacheManager> cacheManagerList;

    @Override
    public void init() {

    }

    @Override
    public void start() {
        log.debug("-------缓存监控开启---------");
        initCache();
        Thread monitor = new MonitorThread();
        monitor.setDaemon(true);
        monitor.start();
    }

    @Override
    public void stop() {
        stop = true;
        log.debug("----------缓存监控停止-------------");
    }

    protected void initCache(){
        for(CacheManager manager  : cacheManagerList){
            manager.init();
        }
    }

    protected void monitorCache(){
        log.debug("cacheManagersLists.size:{}", cacheManagerList.size());

        for(CacheManager manager : cacheManagerList){
            log.debug("Manager:{}",manager);
            try{
                if(manager.needRefresh()){
                    manager.refresh();
                }
            }catch(Exception e){
                log.error("Manager.Exception:{}",manager,e);
            }
        }
    }

    public class MonitorThread extends Thread{
        @Override
        public void run() {
            log.debug("--------开始监控缓存--------");
            while(!stop){
                monitorCache();
                try {
                    Thread.sleep(period);
                } catch (InterruptedException e) {
                    log.error("休眠错误:", e);
                }
                log.debug("--------结束监控缓存--------");
            }
            super.run();
        }
    }

}
