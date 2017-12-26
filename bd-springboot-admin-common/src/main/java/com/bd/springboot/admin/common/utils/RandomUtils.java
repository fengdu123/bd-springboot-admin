package com.bd.springboot.admin.common.utils;

import org.apache.commons.lang.RandomStringUtils;

import java.io.UnsupportedEncodingException;

/**
 * 所在的包名: com.bd.springboot.admin.common
 * 所在的项目名：bd-springboot-admin
 *
 * @author:wangyp
 * @Description: 生成随机数,利用RandomStringUtils生成随机字符串
 * @Date: Created in 20:31 2017/12/26
 */
public class RandomUtils {

    /**
     * 产生5位长度的随机字符串，中文环境下是乱码
     * @return
     */
    public static String fiveString() throws UnsupportedEncodingException {
       String str =  RandomStringUtils.random(5);
        System.out.println(str);
        return str;
    }

    /**
     * 使用指定的字符生成5位长度的随机字符串
     * @return
     */
    public static String fiveRandom(){

        String str = RandomStringUtils.random(5, new char[]{'a','b','c','d','e','f', '1', '2', '3'});
        System.out.println(str);
        return str;
    }

    /**
     * 生成指定长度的字母和数字的随机组合字符串
     * @return
     */
    public static String letterAndString(){

        String str = RandomStringUtils.randomAlphanumeric(5);
        System.out.println(str);
        return str;
    }

    /**
     * 生成随机数字字符串
     * @return
     */
    public static String numberString(){

        String str = RandomStringUtils.randomNumeric(5);

        System.out.println(str);

        return str;
    }

    /**
     * 生成随机[a-z]字符串，包含大小写
     * @return
     */
    public static String letterRandom(){

        String str = RandomStringUtils.randomAlphabetic(5);
        System.out.println(str);
        return str;
    }

    /**
     * 生成从ASCII 32到126组成的随机字符串
     * @return
     */
    public static String AsciiString(){

        String str = RandomStringUtils.randomAscii(4);
        System.out.println(str);
        return str;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        fiveString();
        fiveRandom();
        letterAndString();
        numberString();
        letterRandom();
        AsciiString();
    }

}
