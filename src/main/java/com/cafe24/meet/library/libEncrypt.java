package com.cafe24.meet.library;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * 암호화 라이브러리
 */
public class libEncrypt {
    // 128 크기
    public static String getSHA512(String input){

        String toReturn = null;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;

    }
}
