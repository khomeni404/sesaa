/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.softengine.test;

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

    public static void main(String[] args) {
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
    public static void main2(String[] args) {
        Date d1 = DateUtil.toDate("2007-04-20");
        Date d2 = DateUtil.toDate("2007-05-04");

        Integer days = DateUtil.getDayDifference(d1, d2);
//        Integer days2 = DateUtil.daysBetween(d1, d2);
        Integer month = DateUtil.getMonthDifference(d1, d2);
        Integer year = DateUtil.getYearDifference(d1, d2);
        System.out.println("days = " + days);
        System.out.println("month = " + month);
        System.out.println("year = " + year);
    }
}
