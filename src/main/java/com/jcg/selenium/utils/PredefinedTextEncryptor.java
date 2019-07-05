package com.jcg.selenium.utils;

import org.jasypt.util.text.BasicTextEncryptor;

public class PredefinedTextEncryptor {

    private static BasicTextEncryptor basicTextEncryptor;

    static {
        basicTextEncryptor = new BasicTextEncryptor();
        if (null == System.getProperty("password")) {
            throw new RuntimeException("Password property is not set for local run...");
        }
        basicTextEncryptor.setPassword(System.getProperty("password"));
    }

    public static String decrypt(String encryptedMessage) {
        return basicTextEncryptor.decrypt(encryptedMessage);
    }


    public static void ecrypt(String encryptedMessage) {

        System.out.println(basicTextEncryptor.encrypt(encryptedMessage));

    }

}