package net.softengine.security;

import net.softengine.enam.Applications;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 22/05/2016
 * Created By : Khomeni
 * Version : 1.0
 */
public class DESEDE {

    Cipher eCipher;
    Cipher dCipher;

    /**
     * Pad a string with spaces on the right.
     *
     * @param string String to add spaces
     * @param width  Width of string after padding
     */
    public static String pad(String string, int width) {
        StringBuilder stringBuffer = new StringBuilder(string);
        int space = width - stringBuffer.length();
        while (space-- > 0) {
            stringBuffer.append(' ');
        }

        return stringBuffer.toString();
    }

    public DESEDE(String passphrase) {
        int keyWidth = passphrase.length();
        if (keyWidth < 24)
            passphrase = pad(passphrase, 24);
        try {
            byte[] rawkey = passphrase.getBytes();
            DESedeKeySpec keyspec = new DESedeKeySpec(rawkey);
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
            SecretKey key = keyfactory.generateSecret(keyspec);

            eCipher = Cipher.getInstance("DESede/ECB/NoPadding");
            dCipher = Cipher.getInstance("DESede/ECB/NoPadding");
            eCipher.init(Cipher.ENCRYPT_MODE, key);
            dCipher.init(Cipher.DECRYPT_MODE, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DESEDE(Applications application) {
        try {
            byte[] rawkey = pad(application.NAME, 24).getBytes();
            DESedeKeySpec keyspec = new DESedeKeySpec(rawkey);
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
            SecretKey key = keyfactory.generateSecret(keyspec);

            eCipher = Cipher.getInstance("DESede/ECB/NoPadding");
            dCipher = Cipher.getInstance("DESede/ECB/NoPadding");
            eCipher.init(Cipher.ENCRYPT_MODE, key);
            dCipher.init(Cipher.DECRYPT_MODE, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String str) {
        try {
            int byteLength = str.getBytes("UTF8").length;
            if (byteLength % 8 != 0) {
                byteLength = (byteLength / 8 + 1) * 8;
                str = pad(str, byteLength);
            }
            try {
                byte[] utf8 = str.getBytes("UTF8");
                byte[] enc = eCipher.doFinal(utf8);

                return new sun.misc.BASE64Encoder().encode(enc);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (java.io.UnsupportedEncodingException ue) {
            ue.printStackTrace();
        }

        return str;
    }

    public String decrypt(String str) {
        try {
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
            byte[] utf8 = dCipher.doFinal(dec);

            return (new String(utf8, "UTF8")).trim();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return str;
    }

}
