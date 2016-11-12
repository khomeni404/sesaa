package net.softengine.cypher;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 30/12/15
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 30/12/15
 * Version : 1.0
 */

public class HashTest {
    public static void main(String[] args) {
        try {
            String myString = "Khomeni";
            byte[] bytesOfMessage = myString.getBytes("UTF-8");

            MessageDigest md = MessageDigest.getInstance("SHA-512");   // MD5, MD2, SHA-1  http://docs.oracle.com/javase/6/docs/technotes/guides/security/StandardNames.html
            System.out.println("md = " + md);
            byte[] theDigest = md.digest(bytesOfMessage);
            System.out.println("theDigest = " + theDigest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
