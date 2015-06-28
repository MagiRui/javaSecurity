package com.magiRui.security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import sun.plugin2.message.Message;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by JiangRui on 2015/6/28.
 */
public class SecuritySHA {

    private static String src = "securityMD jr";

    public static void main(String[] args){

        jdkSHA1();
        ccSha1();

    }

    public static void jdkSHA1(){

        try {

            MessageDigest md = MessageDigest.getInstance("SHA");
            byte[] bytes = md.digest(src.getBytes());
            System.out.println(Hex.encodeHexString(bytes));


            md.update(src.getBytes());
            byte[] bytesArray = md.digest();
            System.out.println(Hex.encodeHexString(bytesArray));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }


    public static void ccSha1(){

        System.out.println(Hex.encodeHexString(DigestUtils.sha(src.getBytes())));

    }
}
