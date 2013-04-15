package org.culliam.chooseit.util;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-15
 * Time: обнГ8:21
 */
public class SpellComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        try{
            String s1 = new String(o1.toString().getBytes("GBK"), "ISO-8859-1");
            String s2 = new String(o2.toString().getBytes("GBK"), "ISO-8859-1");
            int temp = s1.compareTo(s2);
            return temp ;

        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
