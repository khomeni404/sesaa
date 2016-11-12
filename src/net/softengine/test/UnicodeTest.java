package net.softengine.test;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 08/01/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 08/01/16
 * Version : 1.0
 */
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.regex.Pattern;

public class UnicodeTest {
    public static void main(String[] args) {
        //testWestern();
        //testBengali();

        System.out.println(toHTML("স্বাস্থ্য নিলয়"));


    }
    public static String toHTML(String unicode) {
        String output = "";

        char[] charArray = unicode.toCharArray();

        for (int i = 0; i < charArray.length; ++i) {
            char a = charArray[i];
            if ((int) a > 255) {
                output += "&#" + (int) a + ";";
            } else {
                output += a;
            }
        }
        return output;
    }

    public static String toJAVA(String unicode) {
        String output = "";

        char[] charArray = unicode.toCharArray();

        for (int i = 0; i < charArray.length; ++i) {
            char a = charArray[i];
            if ((int) a > 255) {
                output += "\\u" + Integer.toHexString((int) a);
            } else {
                output += a;
            }
        }

        return output;
    }

    public static void testWestern() throws UnsupportedEncodingException {
        String unicodeStr= "\u00c2"; //This is a capital A with an accent.;
        String charsetName= "ISO-8859-1";
        System.out.println("Input (outputted as default charset - normally unicode): "+unicodeStr);
        attempt8bitCharsetConversion(unicodeStr, charsetName);
    }

    public static void testBengali() throws UnsupportedEncodingException {
        String unicodeStr = "\u0986\u09AE\u09BF \u0995\u09BF\u0982\u09AC\u09A6\u09A8\u09CD\u09A4\u09BF\u09B0 \u0995\u09A5\u09BE \u09AC\u09B2\u099B\u09BF";
        String charsetName= "x-iscii-be";
        System.out.println(unicodeStr);
        //attempt8bitCharsetConversion(unicodeStr, charsetName);
        String utf = "Some UTF-8 String";
        byte[] data = unicodeStr.getBytes("ASCII");
        String ascii = new String(data);
        System.out.println(data);


        String s = unicodeStr;

        String s1 = Normalizer.normalize(s, Normalizer.Form.NFKD);
        String regex = Pattern.quote("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");

        String s2 = new String(s1.replaceAll(regex, "").getBytes("ascii"), "ascii");

        System.out.println(s2);
        System.out.println(s.length() == s2.length());
    }

    public static void attempt8bitCharsetConversion(String input, String charsetName) throws UnsupportedEncodingException {
        SortedMap<String, Charset> availableCharsets = Charset
                .availableCharsets();
        System.out.println("entry = 1");
        for (Entry<String, Charset> entry : availableCharsets.entrySet()) {
            System.out.println("entry = 2");
            if (charsetName.equalsIgnoreCase(entry.getKey())) {
                System.out.println("entry = ");
                System.out.println("HEXED input : "+ toHex(input.getBytes(Charset.defaultCharset().name())));
                System.out.println("HEXED output: "+ toHex(input.getBytes(entry.getKey())));
            }
        }
        throw new UnsupportedEncodingException(charsetName+ " is not supported on this system");
    }

    public static String toHex(byte[] input) throws UnsupportedEncodingException {
        return String.format("%x", new BigInteger(input));
    }
}
