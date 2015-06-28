package com.magiRui.security;



import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by JiangRui on 2015/6/28.
 */
public class SecurityMD {

    private static String src = "securityMD 91jr";

    public static void main(String[] args){

        jdkMD5();
        jdkMD2();
        ccMd5();
    }


    public static void jdkMD5(){

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(src.getBytes());
            System.out.println(Hex.encodeHexString(md5Bytes));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void jdkMD2(){

        try {

            MessageDigest md = MessageDigest.getInstance("MD2");
            byte[] md5Bytes = md.digest(src.getBytes());
            System.out.println(Hex.encodeHexString(md5Bytes));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    public static void ccMd5(){

        System.out.println(DigestUtils.md5Hex(src.getBytes()));

    }


}
