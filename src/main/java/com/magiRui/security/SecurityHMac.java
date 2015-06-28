
package com.magiRui.security;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by JiangRui on 2015/6/28.
 */
public class SecurityHMac {

    private static final String src = "message degist 91jr";

    public static void main(String[] args){

        jdkHmacMD5();

    }

    public static void jdkHmacMD5(){

        try {

            //生成密钥
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] key = secretKey.getEncoded();



            SecretKey restoreSecretKey = new SecretKeySpec(key,"HmacMD5");
            Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
            mac.init(restoreSecretKey);
            byte[] hmacMD5Byte = mac.doFinal();

            System.out.println(" >>>>>>>>>>>>  " + Hex.encodeHexString(hmacMD5Byte));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}
