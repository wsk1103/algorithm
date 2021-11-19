package com.example;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.FileSystemUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author sk
 * @time 2019/10/28
 * @desc say
 **/
public class FileUtil {

    /**
     * 获取文件的后缀名
     *
     * @param fileName the file name
     * @return png or jpg（不带点）
     */
    public static String getFileSuffix(String fileName) {
        if (StringUtils.isBlank(fileName)) {
            return fileName;
        }
        int index = StringUtils.lastIndexOf(fileName, ".");
        if (index <= 0) {
            return fileName;
        }
        return StringUtils.substring(fileName, index + 1);
    }

    public static void downFile(String urlAddress, String save) {
        long start = System.currentTimeMillis();
        try {
            URL url = new URL(urlAddress);
            FileUtils.copyURLToFile(url, new File(save));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.err.println(String.format("thread: %s, 下载文件url:[%s],fileName:[%s],耗时：[%s]ms",
                    Thread.currentThread().getName(),
                    urlAddress, save, System.currentTimeMillis() - start));
        }

    }

    /**
     * 从URL 下载文件
     *
     * @param urlString
     * @param filename
     * @param savePath
     * @throws Exception
     */
    public static void downFile(String urlString, String filename, String savePath) throws Exception {
        long start = System.currentTimeMillis();
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        // 设置请求超时为5s
        con.setConnectTimeout(5 * 1000);
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        File sf = new File(savePath);
        if (!sf.exists()) {
            sf.mkdirs();
        }
        try (InputStream is = con.getInputStream();
             OutputStream os = new FileOutputStream(sf.getPath() + File.separator + filename)) {
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        }
        System.err.println(String.format("thread: %s, 下载文件url:[%s],fileName:[%s],耗时：[%s]ms",
                Thread.currentThread().getName(),
                urlString, filename, System.currentTimeMillis() - start));
    }

    /**
     * 复制文件
     *
     * @param source 来源
     * @param target 目标
     */
    public static void copy(String source, String target) {
        long start = System.currentTimeMillis();
        File fromFile = new File(source);
        File toFile = new File(target);
        try {
            Files.copy(fromFile, toFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.err.println(String.format("复制文件,源文件[%s]，目标路径[%s],耗时：[%s]ms", source, target, System.currentTimeMillis() - start));
        }
    }

    /**
     * 复制文件
     *
     * @param source 来源
     * @param target 目标
     */
    public static void copyFileUsingFileChannels(String source, String target) throws IOException {
        long start = System.currentTimeMillis();
        File sourceFile = new File(source);
        if (!sourceFile.exists()) {
            System.err.println(String.format("文件不存在：%s", source));
        }
        File targetFile = new File(target);
        try (FileChannel inputChannel = new FileInputStream(sourceFile).getChannel();
             FileChannel outputChannel = new FileOutputStream(targetFile).getChannel()) {
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            System.err.println(String.format("复制文件,源文件[%s]，目标路径[%s],耗时：[%s]ms", source, target, System.currentTimeMillis() - start));
        }
    }

    /**
     * 保存文件
     *
     * @param value
     * @param path
     * @return
     */
    public static String saveFile(String value, String path, String fileName) throws Exception {

        File file = new File(path + fileName);
        try (OutputStream out = new FileOutputStream(file);) {
            byte[] bytes = value.getBytes();
            File directory = new File(path);
            // 检查目录是否存在
            if (!directory.exists()) {
                // 创建目录
                directory.mkdirs();
            }
            out.write(bytes);
            out.flush();
            return file.getPath();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 保存文件
     *
     * @param bytes
     * @param path
     * @param fileName
     * @return
     * @throws Exception
     */
    public static String saveFile(byte[] bytes, String path, String fileName) throws Exception {
        OutputStream out = null;
        try {
            File directory = new File(path);
            // 检查目录是否存在
            if (!directory.exists()) {
                // 创建目录
                directory.mkdirs();
            }
            File file = new File(path + fileName);
            out = new FileOutputStream(file);
            out.write(bytes);
            out.flush();
            return file.getPath();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 读取文件
     *
     * @param filePath 文件路径
     * @return
     */
    public static String readFile(String filePath) {
        File file = new File(filePath);
        try (BufferedReader br = Files.newReader(file, StandardCharsets.UTF_8)) {
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据文件路径读取byte[] 数组
     */
    public static byte[] readFileByBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } else {
            try (ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length())) {
                BufferedInputStream in;
                in = new BufferedInputStream(new FileInputStream(file));
                short bufSize = 1024;
                byte[] buffer = new byte[bufSize];
                int len1;
                while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
                    bos.write(buffer, 0, len1);
                }
                return bos.toByteArray();
            }
        }
    }

    /**
     * 删除文件夹
     *
     * @param file the file
     */
    public static void deleteFile(String file) {
        //判断文件不为null或文件目录存在
        deleteFile(new File(file));
    }

    /**
     * 删除文件夹
     *
     * @param file the file
     */
    public static void deleteFile(File file) {
        if (file == null) {
            System.err.println("文件不存在");
            return;
        }
        System.err.println(String.format("开始删除文件，路径,%s", file.getAbsolutePath()));
        if (!file.exists()) {
            System.err.println(String.format("文件不存在,%s", file.getAbsolutePath()));
            return;
        }
        if (!FileSystemUtils.deleteRecursively(file)) {
            System.err.println(String.format("文件删除失败：%s", file.getAbsolutePath()));
        }
    }

    /**
     * 创建文件夹
     *
     * @param path the path
     */
    public static void mkdir(String path) {
        File file = new File(path);
        mkdir(file);
    }

    /**
     * 创建文件夹
     *
     * @param file the file
     */
    public static void mkdir(File file) {
        try {
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    System.err.println(String.format("创建文件失败，路径[%s]", file.getAbsolutePath()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建文件
     *
     * @param path 文件路径 + 文件名
     */
    public static void touch(String path) {
        touch(new File(path));
    }

    /**
     * 创建文件
     *
     * @param file 文件路径 + 文件名
     */
    public static void touch(File file) {
        try {
            Files.touch(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 移动文件
     *
     * @param from 原文件
     * @param to   目标文件
     */
    public static void move(String from, String to) {
        move(new File(from), new File(to));
    }

    /**
     * 移动文件.
     *
     * @param from 原文件
     * @param to   目标文件
     */
    public static void move(File from, File to) {
        try {
            System.err.println(String.format("移动文件，源路径[%s]，目标路径[%s]", from.getAbsolutePath(), to.getAbsolutePath()));
            Files.move(from, to);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 切割web图片路径，拼接服务器路径
     *
     * @param path      地址
     * @param separator 切割的字段
     * @return splitPath 切割后的地址
     */
    public static String handleUrlToPath(String path, String separator) {
        String splitPath = "";
        if (StringUtils.isEmpty(path) || StringUtils.isEmpty(separator)) {
            return splitPath;
        }
        int indexOf = StringUtils.indexOf(path, separator);
        if (indexOf <= 0) {
            return splitPath;
        }
        return StringUtils.substring(path, indexOf + 1);
    }

}
