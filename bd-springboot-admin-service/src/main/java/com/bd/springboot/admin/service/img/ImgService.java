package com.bd.springboot.admin.service.img;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * 所在的包名: com.bd.springboot.admin.service.img
 * 所在的项目名：bd-springboot-admin
 *
 * 将图片字节生成字符串使用摘要算法加密，将加密生成的字节写到图片最后。验证时，首先读取末尾的加密字节，
 * 读取完成以后删除，再通过摘要算法加密，判断加密值与读取加密值是否相同，如果不同，则图片被篡改。
 * 我在这里使用加盐的md5算法。
 *
 * @author:wangyp
 * @Description:   简易的图片防篡改功能
 * @Date: Created in 16:02 2017/12/26
 */
public class ImgService {

    /**
     * 图片防止篡改部分：
     * 第一步：获取图片的md5字符串，并转为字节数组
     * 第二步：图片末尾加md5字节数组
     * 第三步：封装
     */

    /** 第一步：获取图片的MD5字符串，并转为字节数组。将图片使用md5加密 */
    private static byte[] img2Md5Bytes(File file, String salt) throws Exception{
        FileInputStream inputStream=new FileInputStream(file);
        StringBuilder builder=new StringBuilder();
        byte[] bytes=new byte[1024];
        int bytesRead;
        while ((bytesRead=inputStream.read(bytes))!=-1){
            builder.append(new String(bytes,0,bytesRead));
        }
        inputStream.close();
        builder.append(salt);
        String md5=md5(builder.toString());
        System.out.println("加密后的密码 ：" + md5);
        return hexStringToBytes(md5);
    }

    /** 16进制转字节数组 */
    private static   byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 6 | charToByte(hexChars[pos + 1]));
        }
        System.out.println("转换后的16进制转字节数组 ：" + d);
        System.out.println("转换后的16进制转字节数组 ：" + d.toString());
        return d;
    }

    /** 转换成16进制字节*/
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }


    /** md5加密字符串 */
    private static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            return "";
        }
    }

    /** 第二步：图片末尾加md5字节数组 */
    private static void imgAppendMd5Bytes(File file,byte[] md5Bytes) throws Exception{
        RandomAccessFile accessFile=new RandomAccessFile(file,"rw");
        long length=accessFile.length();
        System.out.println("图片末尾加md5字节数组 ：" + length);
        accessFile.seek(length);
        accessFile.write(md5Bytes);
        accessFile.close();
    }

    /** 第三步：防止图片被篡改，封装而成的方法*/
    private static void preventTamper(File file,String salt) throws Exception{
        byte[] md5bytes=img2Md5Bytes(file,salt);
        imgAppendMd5Bytes(file,md5bytes);
    }


    /**
     * 图片验证部分：
     * 第一步：获取图片的末尾存储的md5字节数组
     * 第二步：去除图片末尾的16个md5字节后，重新计算图片的md5值
     * 第三步：封装为方法
     */
    /** 获取存储在图片末尾的16个md5字节 */
    public static byte[] popMd5Bytes(File file) throws Exception{
        RandomAccessFile accessFile=new RandomAccessFile(file,"rw");
        byte[] bytes=new byte[16];
        long length=accessFile.length();
        accessFile.seek(length-16);
        for (int i=0;i<16;i++){
            bytes[i]=accessFile.readByte();
        }
        accessFile.close();
        return bytes;
    }

    /** 去除图片末尾的16个md5字节 */
    private static void imgDelEndMd5Bytes(File file) throws Exception{
        RandomAccessFile accessFile=new RandomAccessFile(file,"rw");
        FileChannel fc = accessFile.getChannel();
        fc.truncate(accessFile.length()-16);
        fc.close();
        accessFile.close();
    }

    /** 验证图片是否被篡改 */
    private static boolean notTamper(File file,String salt) throws Exception{
        byte[] storageMd5=popMd5Bytes(file);//获取存储在图片末尾的16个md5字节
        imgDelEndMd5Bytes(file);//删除末尾md5字节数组
        byte[] imgMd5=img2Md5Bytes(file,salt);
        return Arrays.equals(storageMd5,imgMd5);
    }

    public static void main(String[] args) throws Exception {

        String salt = "123456";
        File file = new File("d:\\5YE8.jpg");
        System.out.println("文件的名字 ：" + file.getName());
        System.out.println("文件的路径 ：" + file.getPath());
        System.out.println("文件的父文件 ：" + file.getParent());

        /** 图片防止篡改部分*/
        preventTamper(file, salt);

        /** 验证图片是否被篡改*/
        System.out.println(notTamper(file, salt));

    }
}
