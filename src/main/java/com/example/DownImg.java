//package com.example;
//
//import com.alibaba.excel.EasyExcel;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.io.File;
//import java.nio.charset.StandardCharsets;
//import java.util.Arrays;
//import java.util.Random;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @author sk
// * @time 2020/4/17
// * @desc say
// **/
//public class DownImg {
//
//    public static void main(String[] args) throws InterruptedException {
//        final AtomicInteger ai = new AtomicInteger(0);
//        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.setCorePoolSize(8 << 1);
//        threadPoolTaskExecutor.setKeepAliveSeconds(300);
//        threadPoolTaskExecutor.setMaxPoolSize(16 << 1);
//        threadPoolTaskExecutor.setBeanName("sk");
//        threadPoolTaskExecutor.initialize();
//
//        String fileName = "G:\\Desktop\\car.xlsx";
//        String to = "G:\\Desktop\\car2";
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        com.example.DemoDataListener demo = new com.example.DemoDataListener();
//        //不会读取到第一行，需要注意
//        EasyExcel.read(fileName, com.example.ImportC.class, demo).sheet().doRead();
//        List<com.example.ImportC> list = demo.getList();
//        list.forEach(d -> {
//            if (StringUtils.isNotBlank(d.getUrl())) {
//                String sub = d.getUrl().substring(d.getUrl().lastIndexOf("."));
//                String url = URLEncoder.DEFAULT.encode(d.getUrl(), StandardCharsets.UTF_8);
//                String allUrl = url.replace("+", "%2B");
//                String name = d.getCompanyName() + "_" + d.getNumberPlate() + sub;
//                threadPoolTaskExecutor.execute(() -> {
//                    try {
//                        FileUtil.downFile(allUrl, to + File.separator + name);
//                    } catch (Exception e) {
//                        System.err.printf("thread: %s, down fail:url:%s, companyName:%s%n",
//                                Thread.currentThread().getName(),
//                                allUrl,
//                                name);
//                    } finally {
//                        ai.addAndGet(1);
//                    }
//                });
//            } else {
//                System.err.printf("thread: %s,down fail:url is null%n", Thread.currentThread().getName());
//                ai.addAndGet(1);
//            }
//        });
//        while (ai.get() < demo.getList().size()) {
//            Thread.sleep(10 * 1000);
//        }
//        System.gc();
//        System.exit(0);
//    }
//
//    public static int find(int[] num, int left, int right, int find) {
//        if (num.length < 1) {
//            return -1;
//        }
//        int mid = (right + left) / 2;
//        if (left > right) {
//            return -1;
//        }
//        int midNum = num[mid];
//        if (midNum == find) {
//            return mid;
//        } else if (midNum > find) {
//            return find(num, left, mid - 1, find);
//        } else {
//            return find(num, mid + 1, right, find);
//        }
//    }
//
//    public static void sort(int[] all, int left, int right, int[] temp) {
//        if (left < right) {
//            int mid = (left + right) / 2;
//            sort(all, left, mid, temp);
//            sort(all, mid + 1, right, temp);
//            merge(all, left, mid, right, temp);
//        }
//    }
//
//    public static void merge(int[] all, int left, int mid, int right, int[] temp) {
//        int i = left;
//        int j = mid + 1;
//        int t = 0;
//        while (i <= mid && j <= right) {
//            if (all[i] > all[j]) {
//                temp[t++] = all[j++];
//            } else {
//                temp[t++] = all[i++];
//            }
//        }
//        while (i <= mid) {
//            temp[t++] = all[i++];
//        }
//
//        while (j <= right) {
//            temp[t++] = all[j++];
//        }
//
//        t = 0;
//        while (left <= right) {
//            all[left++] = temp[t++];
//        }
//    }
//
//}
