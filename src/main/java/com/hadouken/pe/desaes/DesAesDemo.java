package com.hadouken.pe.desaes;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * @author hadouken@gmail.com
 * @date 2021-02-14 17:15:10
 */
public class DesAesDemo {

    public static void main(String[] args) throws Exception {
        // 原文
        String input = "王春阳";
        // des加密必须是8位
        String key = "12345678";
        // 算法
        String algorithm = "DES";

        String transformation = "DES";
        // Cipher：密码，获取加密对象
        // transformation:参数表示使用什么类型加密
        Cipher cipher = Cipher.getInstance(transformation);
        // 指定秘钥规则
        // 第一个参数表示：密钥，key的字节数组
        // 第二个参数表示：算法
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);
        // 对加密进行初始化
        // 第一个参数：表示模式，有加密模式和解密模式
        // 第二个参数：表示秘钥规则
        cipher.init(Cipher.ENCRYPT_MODE, sks);
        // 进行加密
        byte[] bytes = cipher.doFinal(input.getBytes());
        // 打印字节，因为ascii码有负数，解析不出来，所以乱码
        //        for (byte b : bytes) {
        //            System.out.println(b);
        //        }
        // 打印密文
        String encode = Base64.encode(bytes);
        System.out.println(encode);
    }
}