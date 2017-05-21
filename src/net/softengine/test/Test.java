/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.softengine.test;

import net.softengine.enam.Applications;
import net.softengine.security.DESEDE;
import net.softengine.util.DateUtil;
import org.apache.commons.lang3.text.WordUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author Khomeni
 */
public class Test {
    private static final Pattern PUNCTSPACE = Pattern.compile("[ \\p{Punct}]+");
    private static final Pattern TRANSITION = Pattern.compile("(?<=[^\\p{Lu}])(?=[\\p{Lu}])|(?=[\\p{Lu}][^\\p{Lu}])");

    public static void main23(String[] args) {
        try {
            String dat = "5/1/1985";
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(DateUtil.getAge( sdf.parse(dat)));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    @SuppressWarnings("unchecked")
    public static void main3(String[] args) {
        for (String d : deHumpLambda("hHrlllOkdkKdidIkk")) {
            System.out.println(WordUtils.capitalize(d));
        }
    }
    public static final List<String> deHumpLambda(String text) {
        return Arrays.stream(PUNCTSPACE.split(text))
                .filter(word -> !word.isEmpty())
                .flatMap(word -> Arrays.asList(TRANSITION.split(word)).stream())
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        DESEDE d = new DESEDE(Applications.QRF);
//        System.out.println(d.encrypt("12-02-2017")); = JhoWzPbotJf9ZIDdSqWabw==
        System.out.println(d.encrypt("12-09-2017")); //mWkFJzb4FYT9ZIDdSqWabw==
    }
}
