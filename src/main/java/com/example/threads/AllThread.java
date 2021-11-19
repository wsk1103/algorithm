package com.example.threads;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;

/**
 * @author sk
 * @time 2021/3/16
 * @desc say
 **/
@Data
public class AllThread {

    private String ip;
    private Integer port;
    private Map<Long, ThreadConfig> config;

    @Data
    public static class ThreadConfig {
        private Long id;
        private String threadName;
        private Integer corePoolSize;
        private Integer maxPoolSize;
        private Integer keepAliveSeconds;
        private RejectedExecutionHandler handler;
        private Integer queueCapacity;

        private Integer status;

    }

    private ConcurrentHashMap<String, AllThread> allInfo = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Long, ThreadConfig> configMap = new ConcurrentHashMap<>();
    private final Object lock = new Object();

    public AllThread get(String ip, Integer port, Long id) {
        ThreadConfig a = configMap.get(id);
        if (a == null) {
            return null;
        }
        AllThread all = allInfo.get(ip);
        if (all == null) {
            synchronized (lock) {
                all = new AllThread();
                all.setIp(ip);
                all.setPort(port);
                Map<Long, ThreadConfig> co = new ConcurrentHashMap<>();
                co.put(a.getId(), a);
                all.setConfig(co);

            }
        } else {
            Map<Long, ThreadConfig> co = all.getConfig();
            if (co == null) {
                synchronized (lock) {
                    co = new ConcurrentHashMap<>();
                }
            }
            co.put(a.getId(), a);
            all.setConfig(co);
        }
        return all;
    }

}
