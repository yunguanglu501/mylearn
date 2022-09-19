package com.example.learn.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/29 10:22
 */
public class MD5Util {
    private static final String[] HEX_DIGITS = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public MD5Util() {
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (b < 0) {
            n = b + 256;
        }

        int index1 = n / 16;
        int index2 = n % 16;
        return HEX_DIGITS[index1] + HEX_DIGITS[index2];
    }

    private static String byteArrayToHexString(byte[] input) {
        StringBuilder result = new StringBuilder();
        byte[] var2 = input;
        int var3 = input.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            byte b = var2[var4];
            result.append(byteToHexString(b));
        }

        return result.toString();
    }

    public static String getMD5_32(String origin, String charset, boolean isUpperCase) throws UnsupportedEncodingException {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException var6) {
            throw new RuntimeException(var6);
        }

        md.update(origin.getBytes(charset));
        byte[] bytesResult = md.digest();
        String resultString = byteArrayToHexString(bytesResult);
        return isUpperCase ? resultString.toUpperCase() : resultString;
    }

    public static String getMD5_16(String origin, String charset, boolean isUpperCase) throws UnsupportedEncodingException {
        return getMD5_32(origin, charset, isUpperCase).substring(8, 24);
    }

    public static String getUpperMD5(String origin) {
        try {
            return getMD5_32(origin, "UTF-8", true);
        } catch (UnsupportedEncodingException var2) {
            throw new RuntimeException(var2);
        }
    }

    public static String getMD5(String origin) {
        try {
            return getMD5_32(origin, "UTF-8", false);
        } catch (UnsupportedEncodingException var2) {
            throw new RuntimeException(var2);
        }
    }
}
