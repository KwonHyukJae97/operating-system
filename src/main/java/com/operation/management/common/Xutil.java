package com.operation.management.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Xutil {

    public static String encryptSHA256Emp(String value) throws Exception {

      //비밀번호 복호화
        String encryptData = "";
        try {
           MessageDigest sha = MessageDigest.getInstance("SHA-256");
           sha.update(value.getBytes());
           byte[] digest = sha.digest();
  
           for (int i = 0; i < digest.length; i++) {
              encryptData += Integer.toHexString(digest[i] & 0xFF).toUpperCase();
           }
        } catch (NoSuchAlgorithmException e) {
           throw new Exception("NoSuchAlgorithmException");
        }
        return encryptData;
     }
    
}
